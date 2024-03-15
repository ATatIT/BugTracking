package com.arth.controller;

import java.time.LocalDate;
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
	
	@GetMapping("/projects")
	public String listProjectByStatus(@RequestParam("statusId")Integer statusId,Model model) {
		if(statusId == 0) {
			return "redirect:/listproject";
		}else if(statusId == 5) {
			Integer m = LocalDate.now().getMonthValue();
			List<ProjectEntity> dueProject = p.getDueProjects(m);
			model.addAttribute("p", dueProject);
		}else if(statusId == 2 || statusId == 3) {
			List<ProjectEntity> projects = p.findByProjectStatusId(statusId);
			model.addAttribute("p", projects);
		}else {
			return "ListProject";
		}
		return "ListProject";
	}
}
