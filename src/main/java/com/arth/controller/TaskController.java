package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectStatusEntity;
import com.arth.entity.TaskEntity;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;
import com.arth.repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository t;
	
	@Autowired
	ModuleRepository moduleRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	ProjectStatusRepository projectStatuRepo;
	
	@GetMapping("/newtask")
	public String newTask(Model model) {
		List<ModuleEntity> moduleList = moduleRepo.findAll();
		model.addAttribute("moduleList", moduleList);
		
		List<ProjectEntity> projectList = projectRepo.findAll();
		model.addAttribute("projectList", projectList);
		
		List<ProjectStatusEntity> projectStatusList = projectStatuRepo.findAll();
		model.addAttribute("projectStatusList", projectStatusList);
		return "NewTask";
	}
	
	@PostMapping("/savetask")
	public String svaeTask(TaskEntity task) {
		t.save(task);
		return "redirect:/listtask";
	}
	
	@GetMapping("/listtask")
	public String listTask(Model model) {
		List<TaskEntity> tasks = t.findAll();
		model.addAttribute("t", tasks);
		return "ListTask";
	}
	
	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam("taskId") Integer taskId) {
		t.deleteById(taskId);
		return "redirect:/listtask";
	}
	
}
