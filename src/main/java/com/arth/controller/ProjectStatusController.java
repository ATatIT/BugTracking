package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ProjectStatusEntity;
import com.arth.repository.ProjectStatusRepository;

@Controller
public class ProjectStatusController {

	@Autowired
	ProjectStatusRepository s;
	@GetMapping("/projectstatus")
	public String projectstatus() {
		
		return "NewProjectStatus";
	}
	
	@PostMapping("/saveprojectstatus")
	public String saveProjectStatus(ProjectStatusEntity status) {
		System.out.println(status.getStatus());
		s.save(status);
		return "redirect:/listprojectstatus";
	}
	
	@GetMapping("/listprojectstatus")
	public String listProjectStatus(Model model) {
		List<ProjectStatusEntity> projectstatus = s.findAll();
		model.addAttribute("s", projectstatus);
		return "ListProjectStatus";
	}
	
	@GetMapping("/deleteprojectstatus")
	public String deleteProjectStatus(@RequestParam("statusId") Integer statusId) {
		s.deleteById(statusId);
		return "redirect:/listprojectstatus";
	}
}
