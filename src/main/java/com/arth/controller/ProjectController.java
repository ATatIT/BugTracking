package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.ProjectEntity;
import com.arth.repository.ProjectRepository;

@Controller
public class ProjectController {
	@Autowired
	ProjectRepository p;

	@GetMapping("/project")
	public String project() {
		return "NewProject";
	}

	@PostMapping("/saveproject")
	public String saveproject(ProjectEntity project) {
		System.out.println(project.getProjecttitle());
		
		p.save(project);
		return "Home";
	}
}
