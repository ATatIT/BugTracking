package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectUserEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectUserRepository;
import com.arth.repository.UserRepository;

@Controller
public class ProjectUserController {
	
	@Autowired
	ProjectUserRepository pu;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ProjectUserRepository projectUserRepo;
	
	@GetMapping("/newprojectuser")
	public String newProjectUser(@RequestParam("projectId")Integer projectId,Model model) {
		List<UserEntity> userList = userRepo.findAll();
		model.addAttribute("userList", userList);
		
		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("project", project);
		return "NewProjectUser";
	}
	
	@PostMapping("/saveprojectuser")
	public String saveProjectUser(ProjectUserEntity projectuser) {
		projectuser.setAssignStatus(1);	
		pu.save(projectuser);
		return"redirect:/listprojectuser?projectId="+projectuser.getProjectId();
	}
	
	@GetMapping("/listprojectuser")
	public String listProjectUser(Model model, @RequestParam("projectId")Integer projectId) {
		
		model.addAttribute("pt", projectRepo.findById(projectId).get());
		model.addAttribute("pu", userRepo.getUserByProjectId(projectId));
		model.addAttribute("puhold", userRepo.getUserByProjectIdHold(projectId));
		model.addAttribute("purevoke", userRepo.getUserByProjectIdRevoke(projectId));
		
		return "ListProjectUser";
	}
	
	@GetMapping("/projectuserassignstatus")
	public String projectUserAssignStatus(@RequestParam("projectId")Integer projectId,@RequestParam("userId")Integer userId,@RequestParam("status")Integer status ) {
		ProjectUserEntity pu = projectUserRepo.findByProjectIdAndUserId(projectId, userId);
		pu.setAssignStatus(status);
		projectUserRepo.save(pu);
		return "redirect:/listprojectuser?projectId="+projectId;
	}
	
	@GetMapping("/deleteprojectuser")
	public String deleteProjectUser(@RequestParam("projecuserId") Integer projectUserId) {
		pu.deleteById(projectUserId);
		return"redirect:/listprojectuser";
	}
	
//	@GetMapping("/listallprojectuser")
//	public String listAllProjectUser(Model model) {
//		List<ProjectEntity> allProject = projectRepo.findAll();
//		
//		
//		
//		List<ProjectUserEntity> allProjectUser = pu.findAll();
//		model.addAttribute("allProjectUser", allProjectUser);
//		return "ListAllProjectUser";
//	}
}
