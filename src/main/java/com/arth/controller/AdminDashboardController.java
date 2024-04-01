package com.arth.controller;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arth.entity.ProjectEntity;
import com.arth.entity.RoleEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ProjectRepository;
import com.arth.repository.RoleRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class AdminDashboardController {
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	RoleRepository roleRepo;
	
	
	@GetMapping("/admindashboard")
	public String adminDashboard(HttpSession session , Model model) {
//	UserEntity user = (UserEntity) session.getAttribute("user");
	
	
		
		Integer totalProject = (int) projectRepo.count();
		model.addAttribute("totalProject", totalProject);
		
		Integer OngoingProject =  projectRepo.findByProjectStatusId(3).size();
		model.addAttribute("OngoingProject", OngoingProject);
		
	
		Integer m = LocalDate.now().getMonthValue();
		
		Integer pipelineProject =  projectRepo.findByProjectStatusId(2).size();
		model.addAttribute("pipelineProject", pipelineProject);
		
		Integer dueProject = projectRepo.getDueProjects(m).size();
		model.addAttribute("dueProject", dueProject);
		
		// for chart------------------------------------------------------------
		
		List<ProjectEntity> project = projectRepo.findAll();
		String projectName = ""; 
		String estimatedHours = "";
		for (ProjectEntity p : project) {
			projectName = projectName + "'" + p.getProjecttitle() + "'," ;
			estimatedHours = estimatedHours + p.getEstimatedHours() + ",";
		}
		model.addAttribute("projectName", projectName);
		model.addAttribute("estimatedHours", estimatedHours);
		return "AdminDashboard";
	}
	
	
	
	
}
