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
import com.arth.entity.TaskEntity;
import com.arth.entity.TaskUserEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;
import com.arth.repository.TaskRepository;
import com.arth.repository.TaskUserRepositoy;
import com.arth.repository.UserRepository;

@Controller
public class TaskUserController {

	@Autowired
	TaskUserRepositoy tu;
	
	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ProjectStatusRepository projectStausRepo;
	
	@GetMapping("/newtaskuser")
	public String newTaskUser(@RequestParam("taskId") Integer taskId ,Model model) {
		
		
		TaskEntity task =   taskRepo.findById(taskId).get();
		List<UserEntity> userList = userRepo.getUserByProjectId(task.getProjectId());
		model.addAttribute("userList", userList);
		
		model.addAttribute("task", task);
		
		List<ProjectStatusEntity> projectStatuList = projectStausRepo.findAll();
		model.addAttribute("projectStatusList", projectStatuList);
		
		return "NewTaskUser";
	}
	
	@PostMapping("/savetaskuser")
	public String saveTaskUser(TaskUserEntity taskuser) {
		taskuser.setAssignStatus(1);
		tu.save(taskuser);
		return "redirect:/listtaskuser?taskId="+taskuser.getTaskId();
	}
	
	@GetMapping("/listtaskuser")
	public String listTaskUser(@RequestParam("taskId") Integer taskId,Model model) {
		model.addAttribute("task", taskRepo.getById(taskId));
		model.addAttribute("taskuser", userRepo.getUserByTaskId(taskId));
		return "ListTaskUser";
	}
	
	@GetMapping("/deletetaskuser")
	public String deleteTaskUser(@RequestParam("taskuserId") Integer taskuserId) {
		tu.deleteById(taskuserId);
		return "redirect:/listtaskuser";
	}
}
