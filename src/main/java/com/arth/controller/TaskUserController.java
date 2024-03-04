package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ProjectStatusEntity;
import com.arth.entity.TaskEntity;
import com.arth.entity.TaskUserEntity;
import com.arth.entity.UserEntity;
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
	ProjectStatusRepository projectStausRepo;
	
	@GetMapping("/newtaskuser")
	public String newTaskUser(Model model) {
		List<UserEntity> userList = userRepo.findAll();
		model.addAttribute("userList", userList);
		
		List<TaskEntity> taskList = taskRepo.findAll();
		model.addAttribute("taskList", taskList);
		
		List<ProjectStatusEntity> projectStatuList = projectStausRepo.findAll();
		model.addAttribute("projectStatusList", projectStatuList);
		
		return "NewTaskUser";
	}
	
	@PostMapping("/savetaskuser")
	public String saveTaskUser(TaskUserEntity taskuser) {
		taskuser.setAssignStatus(1);
		tu.save(taskuser);
		return "redirect:/listtaskuser";
	}
	
	@GetMapping("/listtaskuser")
	public String listTaskUser(Model model) {
		List<TaskUserEntity> taskusers = tu.findAll();
		model.addAttribute("tu", taskusers);
		return "ListTaskUser";
	}
	
	@GetMapping("/deletetaskuser")
	public String deleteTaskUser(@RequestParam("taskuserId") Integer taskuserId) {
		tu.deleteById(taskuserId);
		return "redirect:/listtaskuser";
	}
}
