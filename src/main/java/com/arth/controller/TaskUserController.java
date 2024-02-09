package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.TaskUserEntity;
import com.arth.repository.TaskUserRepositoy;

@Controller
public class TaskUserController {

	@Autowired
	TaskUserRepositoy tu;
	
	@GetMapping("/newtaskuser")
	public String newTaskUser() {
		return "NewTaskUser";
	}
	
	@PostMapping("/savetaskuser")
	public String saveTaskUser(TaskUserEntity taskuser) {
		tu.save(taskuser);
		return "redirect:/listtaskuser";
	}
	
	@GetMapping("/listtaskuser")
	public String listTaskUser(Model model) {
		List<TaskUserEntity> taskusers = tu.findAll();
		model.addAttribute("tu", taskusers);
		return "ListTaskUser";
	}
}
