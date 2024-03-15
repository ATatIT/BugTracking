package com.arth.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.TaskEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.TaskRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeveloperDashboardController {

	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ModuleRepository moduleRepo;
	
	@Autowired
	TaskRepository taskRepo;

	@GetMapping("/developerdashboard")
	public String developerDashboard(HttpSession session, Model model) {

		LocalDate d = LocalDate.now();
		Integer m = d.getMonthValue();

		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer project = projectRepo.getProjectsByUserId(user.getUserId());

		if (project == null) {
			model.addAttribute("project", "Assing Soon");
		} else {

			model.addAttribute("project", project);
		}

		Integer dueProject = projectRepo.getDueProjectsByUserId(m, user.getUserId());
		model.addAttribute("dueProject", dueProject);

		Integer OngoingProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 3);
		model.addAttribute("OngoingProject", OngoingProject);

		Integer pipelineProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 2);
		model.addAttribute("pipelineProject", pipelineProject);

		return "DeveloperDashboard";
	}




	@GetMapping("/listprojectofdev")
	public String listProjectOfDev(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> project = projectRepo.getProjectsOfUserId(user.getUserId());
		model.addAttribute("project", project);
		return "ListProjectOfDev";
	}
	
	
	@GetMapping("/listmoduleofdev")
	public String listModuleOfDev(@RequestParam("projectId")Integer projectId,HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("project", project);
		
		List<ModuleEntity> module = moduleRepo.findByProjectIdAndUserId(projectId, user.getUserId());
		model.addAttribute("module", module);
		return "ListModuleOfDev";
	}
	
	
	@GetMapping("/listtaskofdev")
	public String listTaskOfDev(@RequestParam("moduleId")Integer moduleId,HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		ProjectEntity project = projectRepo.findById(moduleRepo.findById(moduleId).get().getProjectId()).get();
		model.addAttribute("project", project);
		
		ModuleEntity module = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", module);
		
		List<TaskEntity> task = taskRepo.findByModuleIdAndUserId(moduleId, user.getUserId());
		model.addAttribute("task", task);
		return "ListTaskOfDev";
	}
	
	@GetMapping("adddailylog")
	public String addDailyLog() {
		return "";
	}
	
}