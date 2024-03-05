package com.arth.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arth.entity.UserEntity;
import com.arth.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminDashboardController {
	@Autowired
	ProjectRepository projectRepo;
	
	@GetMapping("/admindashboard")
	public String adminDashboard(HttpSession session , Model model) {
//		UserEntity user = (UserEntity) session.getAttribute("user");
		
		
		Integer totalProject = (int) projectRepo.count();
		model.addAttribute("totalProject", totalProject);
		
		Integer OngoingProject =  projectRepo.getProjectAccordingToSatatus(3);
		model.addAttribute("OngoingProject", OngoingProject);
		
		LocalDate d = LocalDate.now();
		Integer m = d.getMonthValue();
		
		Integer pipelineProject =  projectRepo.getProjectAccordingToSatatus(2);
		model.addAttribute("pipelineProject", pipelineProject);
		
		Integer dueProject = projectRepo.getDueProjects(m);
		model.addAttribute("dueProject", dueProject);
		return "AdminDashboard";
	}
}
