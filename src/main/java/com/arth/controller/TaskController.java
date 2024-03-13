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
	public String newTask(@RequestParam("moduleId") Integer moduleId,Model model) {
		ModuleEntity module = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", module);
		
		ProjectEntity project = projectRepo.findById(module.getProjectId()).get();
		model.addAttribute("project", project);
		
		List<ProjectStatusEntity> projectStatusList = projectStatuRepo.findAll();
		model.addAttribute("projectStatusList", projectStatusList);
		return "NewTask";
	}
	
	@PostMapping("/savetask")
	public String svaeTask(TaskEntity task) {
		t.save(task);
		return "redirect:/listtask?moduleId="+task.getModuleId();
	}
	
	@GetMapping("/listtask")
	public String listTask(@RequestParam("moduleId") Integer moduleId,Model model) {
		List<TaskEntity> tasks = t.findByModuleId(moduleId);		
		ModuleEntity module = moduleRepo.findById(moduleId).get();
		
		model.addAttribute("module", module);
		model.addAttribute("t", tasks);
		
		ProjectEntity project = projectRepo.findById(module.getProjectId()).get();
		model.addAttribute("project", project);
		return "ListTask";
	}
	
	@GetMapping("/deletetask")
	public String deleteTask(@RequestParam("taskId") Integer taskId) {
		int moduleId = t.findById(taskId).get().getModuleId();
		t.deleteById(taskId);
		return "redirect:/listtask?moduleId="+moduleId;
	}
	
}
