package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.RoleEntity;
import com.arth.repository.RoleRepository;

@Controller
public class RoleController {

	@Autowired
	RoleRepository r;

	@GetMapping("/rolename")
	public String rolename() {
		return "RoleName";
	}

	@PostMapping("/saverole")
	public String saverole(RoleEntity role) {
		System.out.println(role.getRoleName());
		r.save(role);
		return "redirect:/listrole";
	}
	
	@GetMapping("/listrole")
	public String listRole(Model model) {
		List<RoleEntity> roles = r.findAll();
		model.addAttribute("r", roles);
		return "ListRole";
	}

}
