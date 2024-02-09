package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.ProjectUserEntity;
import com.arth.repository.ProjectUserRepository;

@Controller
public class ProjectUserController {
	
	@Autowired
	ProjectUserRepository pu;
	
	@GetMapping("/newprojectuser")
	public String newProjectUser() {
		return "NewProjectUser";
	}
	
	@PostMapping("/saveprojectuser")
	public String saveProjectUser(ProjectUserEntity projectuser) {
		pu.save(projectuser);
		return"redirect:/listprojectuser";
	}
	
	@GetMapping("/listprojectuser")
	public String listProjectUser(Model model) {
		List<ProjectUserEntity> projectusers = pu.findAll();
		model.addAttribute("pu", projectusers);
		return "ListProjectUser";
	}
}
