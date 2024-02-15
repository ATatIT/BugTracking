package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectStatusEntity;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;

@Controller
public class ProjectController {
	@Autowired
	ProjectRepository p;

	@Autowired
	ProjectStatusRepository projectStausRepo;
	
	@GetMapping("/newproject")
	public String project(Model model) {
		List<ProjectStatusEntity> projectStatuList = projectStausRepo.findAll();
		model.addAttribute("projectStatuList", projectStatuList);
		return "NewProject";
	}

	@PostMapping("/saveproject")
	public String saveproject(ProjectEntity project) {
		System.out.println(project.getProjecttitle());
		
		p.save(project);
		return "redirect:/listproject";
	}
	
	@GetMapping("/listproject")
	public String listProject(Model model) {
		List<ProjectEntity> projects = p.findAll();
		model.addAttribute("p", projects);
		return "ListProject";
	}
	
	@GetMapping("deleteproject")
	public String deleteProject(@RequestParam("projectId")Integer projectId) {
		p.deleteById(projectId);
		return "redirect:/listproject";
	}
}
