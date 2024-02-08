package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.ModuleEntity;
import com.arth.repository.ModuleRepository;

@Controller
public class ModuleController {

	@Autowired
	ModuleRepository m;
	
	@GetMapping("/module")
	public String newModule() {
		return "NewModule";
	}
	
	@PostMapping("/savemodule")
	public String saveModule(ModuleEntity module) {
		m.save(module);
		return "redirect:/listmodule";
	}
	
	@GetMapping("/listmodule")
	public String lisrModule(Model model) {
		List<ModuleEntity> modules = m.findAll();
		model.addAttribute("m", modules);
		return "ListModule";
	}
	
}
