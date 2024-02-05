package com.arth.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.roleBean;

@Controller
public class RoleController {

	@GetMapping("/rolename")
	public String rolename(){
		return "RoleName";
	}
	
	@PostMapping("/saverole")
	public String saverole(roleBean role) {
		System.out.println(role.getRoleName());
		return "Home";
	}
	
}
