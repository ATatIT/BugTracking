package com.arth.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arth.entity.ProjectEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ProjectRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeveloperDashboardController {

	@Autowired
	ProjectRepository projectRepo;

	@GetMapping("/developerdashboard")
	public String developerDashboard(HttpSession session, Model model) {

		LocalDate d = LocalDate.now();
		Integer m = d.getMonthValue();

		UserEntity user = (UserEntity) session.getAttribute("user");
		Integer project = projectRepo.getProjectsByUserId(user.getUserId());

		if (project == null) {
			model.addAttribute("project", "Assing Soon");
		} else {

			model.addAttribute("project", project);
		}

		Integer dueProject = projectRepo.getDueProjectsByUserId(m, user.getUserId());
		model.addAttribute("dueProject", dueProject);

		Integer OngoingProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 3);
		model.addAttribute("OngoingProject", OngoingProject);

		Integer pipelineProject = projectRepo.getProjectsByUserIdAccordingToStatus(user.getUserId(), 2);
		model.addAttribute("pipelineProject", pipelineProject);

		return "DeveloperDashboard";
	}




	@GetMapping("/listprojectofdev")
	public String listProjectOfDev(HttpSession session, Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		List<ProjectEntity> project = projectRepo.getProjectsOfUserId(user.getUserId());
		model.addAttribute("project", project);
		return "ListProjectOfDev";
	}
}