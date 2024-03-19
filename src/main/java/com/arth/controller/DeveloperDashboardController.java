package com.arth.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectStatusEntity;
import com.arth.entity.ProjectUserEntity;
import com.arth.entity.TaskEntity;
import com.arth.entity.TaskUtilizedHoursEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;
import com.arth.repository.ProjectUserRepository;
import com.arth.repository.TaskRepository;
import com.arth.repository.TaskUtilizedHoursRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

@Controller
public class DeveloperDashboardController {

	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ModuleRepository moduleRepo;
	
	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	ProjectUserRepository projectUserRepo;
	
	@Autowired
	ProjectStatusRepository projectStatusRepo;
	
	@Autowired
	TaskUtilizedHoursRepository tuhRepo;

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
	
	@GetMapping("/developerprofile")
	public String developerProfile() {
		return "DeveloperProfile";
	}

	
	@GetMapping("adddailylog")
	public String addDailyLog(@RequestParam("taskId")Integer taskId,@RequestParam("moduleId")Integer moduleID,@RequestParam("projectId")Integer projectId,HttpSession session,Model model) {
		
		UserEntity user = (UserEntity) session.getAttribute("user");
		model.addAttribute("user", user);
		
		LocalDate d = LocalDate.now();
		model.addAttribute("date", d);
		
		// change according to future development
		ProjectEntity project = projectRepo.findById(projectId).get();
		model.addAttribute("project", project);
		
		ModuleEntity module = moduleRepo.findById(moduleID).get();
		model.addAttribute("module", module);
		
		TaskEntity task = taskRepo.findById(taskId).get();
		model.addAttribute("task", task);
		
		List<ProjectStatusEntity> status =  projectStatusRepo.findAll();
		model.addAttribute("status", status);
		
		return "AddDailyLog";
	}
	
	@PostMapping("/savedailylog")
	public String saveDailyLog(TaskUtilizedHoursEntity dailyLog) {
		
		tuhRepo.save(dailyLog);
		
		/*
		 * TaskEntity upDateTask = taskRepo.findById(dailyLog.getTaskId()).get();
		 * upDateTask.setStatus(dailyLog.getStatus());
		 */
		return "redirect:/listtaskofdev?moduleId="+dailyLog.getModuleId();
	}
	
	
	
	
	
}
