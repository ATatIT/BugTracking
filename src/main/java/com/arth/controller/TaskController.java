package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.TaskEntity;
import com.arth.repository.TaskRepository;

@Controller
public class TaskController {

	@Autowired
	TaskRepository t;
	@GetMapping("/task")
	public String newTask() {
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
	
}
