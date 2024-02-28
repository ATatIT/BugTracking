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
	
	@GetMapping("/newprojectuser")
	public String newProjectUser(Model model) {
		List<UserEntity> userList = userRepo.findAll();
		model.addAttribute("userList", userList);
		
		List<ProjectEntity> projectList = projectRepo.findAll();
		model.addAttribute("projectList", projectList);
		return "NewProjectUser";
	}
	
	@PostMapping("/saveprojectuser")
	public String saveProjectUser(ProjectUserEntity projectuser) {
		projectuser.setAssignStatus(1);	
		pu.save(projectuser);
		return"redirect:/listprojectuser";
	}
	
	@GetMapping("/listprojectuser")
	public String listProjectUser(Model model, @RequestParam("projectId")Integer projectId) {
		
		model.addAttribute("pt", projectRepo.findById(projectId).get());
		model.addAttribute("pu", userRepo.getUserByProjectId(projectId));
		
		return "ListProjectUser";
	}
	
	@GetMapping("/deleteprojectuser")
	public String deleteProjectUser(@RequestParam("projecuserId") Integer projectUserId) {
		pu.deleteById(projectUserId);
		return"redirect:/listprojectuser";
	}
}
