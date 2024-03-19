

package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectStatusEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class ModuleController {

	@Autowired
	ModuleRepository moduleRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ProjectStatusRepository projectStatuRepo;
	
	@GetMapping("/newmodule")
	public String newModule(@RequestParam("projectId") Integer projectId,Model model) {
		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("project", project);
		
		List<ProjectStatusEntity> projectStatusList = projectStatuRepo.findAll();
		model.addAttribute("projectStatusList", projectStatusList);
		return "NewModule";
	}
	
	@PostMapping("/savemodule")
	public String saveModule(ModuleEntity module) {
		moduleRepo.save(module);
		return "redirect:/listmodule?projectId="+module.getProjectId();
	}
	
	@GetMapping("/listmodule")
	public String lisrModule(@RequestParam("projectId") Integer projectId ,Model model) {
		List<ModuleEntity> modules = moduleRepo.findByProjectId(projectId);
		ProjectEntity project = projectRepo.findById(projectId).get();
		
		model.addAttribute("project", project);
		model.addAttribute("m", modules);
		return "ListModule";
	}
	
	@GetMapping("/deletemodule")
	public String deleteModule(@RequestParam("moduleId") Integer moduleId) {
		int projectId = moduleRepo.findById(moduleId).get().getProjectId();
		moduleRepo.deleteById(moduleId);
		return "redirect:/listmodule?projectId="+projectId;
	}
	
	@GetMapping("/viewmodule")
	public String viewModule(@RequestParam("moduleId") Integer moduleId,Model model) {
		ModuleEntity module = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", module);
		
		ProjectEntity project = projectRepo.findById(module.getProjectId()).get();
		model.addAttribute("project", project);
		return "ViewModule";
	}
	
//developer-------------------------------------------------------------------------------------------------------------
	@GetMapping("/listmoduleofdev")
	public String listModuleOfDev(@RequestParam("projectId")Integer projectId,HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("project", project);
		
		List<ModuleEntity> module = moduleRepo.findByProjectIdAndUserId(projectId, user.getUserId());
		model.addAttribute("module", module);
		return "ListModuleOfDev";
	}
	
	//view
	@GetMapping("/viewmoduleofdev")
	public String viewModuleOfDev(@RequestParam("moduleId") Integer moduleId,Model model) {
		ModuleEntity module = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", module);
		
		String project = projectRepo.findById(module.getProjectId()).get().getProjecttitle();
		model.addAttribute("project", project);
		return "ViewModuleOfDev";
	}
}
