package com.arth.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.arth.dto.BugReportDto;
import com.arth.entity.ProjectEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.BugReportRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class PmDashboardController {
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BugReportRepository bugReportRepo;
	
	@GetMapping("/pmdashboard")
	public String pmDashboard(HttpSession session,Model model) {
		
		//for widgets
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
		
		// for chart------------------------------------------------------------
		
				List<ProjectEntity> project = projectRepo.getProjectsOfUserId(user.getUserId());
				String projectName = ""; 
				String estimatedHours = "";
				String totalUh = "";
				for (ProjectEntity p : project) {
					projectName = projectName + p.getProjecttitle() + "," ;
					estimatedHours = estimatedHours + p.getEstimatedHours() + ",";
					totalUh = totalUh + p.getTotalUtilizedHours() + ",";
				}
				model.addAttribute("projectName", projectName);
				model.addAttribute("estimatedHours", estimatedHours);
				model.addAttribute("totalUh", totalUh);
				
				
				List<Integer> projectId = new ArrayList<>();
				for (ProjectEntity p : project) {
					projectId.add(p.getProjectId());
				}
				List<BugReportDto> bugs = bugReportRepo.getBugsAccordingProjects(projectId);
				String projectNameForBug = ""; 
				String approveBugs = "";
				String bug = "";
				for (BugReportDto b : bugs) {
					projectNameForBug = projectNameForBug + b.getProjectTitle() + "," ;
					approveBugs = approveBugs + b.getApproveBugs() + ",";
					bug = bug + b.getBugs() + ",";
				}
				model.addAttribute("projectNameForBug", projectNameForBug);
				model.addAttribute("approveBugs", approveBugs);
				model.addAttribute("bug", bug);	
				

		return "PmDashboard";
	}
}
