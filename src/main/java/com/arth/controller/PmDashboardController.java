package com.arth.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arth.entity.ProjectEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ProjectRepository;
import com.arth.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PmDashboardController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping("/pmdashboard")
	public String pmDashboard(HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer totalproject = projectRepo.findProjectsByUserId(user.getUserId());
		model.addAttribute("totalproject", totalproject);
		
		Integer m = LocalDate.now().getMonthValue();
		Integer dueProject = projectRepo.getDueProjectsByUserId(m, user.getUserId());
		model.addAttribute("dueProject", dueProject);
		
		Integer OngoingProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 3);
		model.addAttribute("OngoingProject", OngoingProject);

		Integer pipelineProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 2);
		model.addAttribute("pipelineProject", pipelineProject);
		
		model.addAttribute("team", userRepo.pmTeam(user.getUserId()).size());
		return "PmDashboard";
	}
}
