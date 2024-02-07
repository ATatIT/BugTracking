package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		return "Home";
	}

}
