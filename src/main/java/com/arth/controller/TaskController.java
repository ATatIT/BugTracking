package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.ModuleEntity;
import com.arth.entity.ProjectEntity;
import com.arth.entity.ProjectStatusEntity;
import com.arth.entity.TaskEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.ModuleRepository;
import com.arth.repository.ProjectRepository;
import com.arth.repository.ProjectStatusRepository;
import com.arth.repository.TaskRepository;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

import jakarta.servlet.http.HttpSession;

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
	
	@GetMapping("/viewtask")
	public String viewTask(@RequestParam("taskId") Integer taskId,Model model) {
		TaskEntity task = t.findById(taskId).get();
		model.addAttribute("task", task);
		
		String module = moduleRepo.findById(task.getModuleId()).get().getModuleName();
		model.addAttribute("module", module);
		
		String project = projectRepo.findById(task.getProjectId()).get().getProjecttitle();
		model.addAttribute("project", project);
		return "ViewTask";
	}
	
	@GetMapping("/edittask")
	public String editTask(@RequestParam("taskId")Integer taskId,Model model) {
		
		List<ProjectStatusEntity> projectStatusList = projectStatuRepo.findAll();
		model.addAttribute("projectStatusList", projectStatusList);
		
		TaskEntity task = t.findById(taskId).get();
		model.addAttribute("task", task);
		
		String project = projectRepo.findById(task.getProjectId()).get().getProjecttitle();
		model.addAttribute("project", project);
		
		String module = moduleRepo.findById(task.getModuleId()).get().getModuleName();
		model.addAttribute("module", module);
		return "EditTask";
	}
	
//developer-------------------------------------------------------------------------------------------
	@GetMapping("/listtaskofdev")
	public String listTaskOfDev(@RequestParam("moduleId")Integer moduleId,HttpSession session,Model model) {
		UserEntity user = (UserEntity) session.getAttribute("user");
		
		ProjectEntity project = projectRepo.findById(moduleRepo.findById(moduleId).get().getProjectId()).get();
		model.addAttribute("project", project);
		
		ModuleEntity module = moduleRepo.findById(moduleId).get();
		model.addAttribute("module", module);
		
		List<TaskEntity> task = t.findByModuleIdAndUserId(moduleId, user.getUserId());
		model.addAttribute("task", task);
		return "ListTaskOfDev";
	}
	
	//view
	@GetMapping("/viewtaskofdev")
	public String viewTaskOfDev(@RequestParam("taskId") Integer taskId,Model model) {
		
		TaskEntity task = t.findById(taskId).get();
		model.addAttribute("task", task);
		
		String module = moduleRepo.findById(task.getModuleId()).get().getModuleName();
		model.addAttribute("module", module);
		
		String project = projectRepo.findById(task.getProjectId()).get().getProjecttitle();
		model.addAttribute("project", project);
		return"ViewTaskOfDev";
	}
}
