package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.RoleEntity;
import com.arth.repository.RoleRepository;

@Controller
public class RoleController {

	@Autowired
	RoleRepository r;

	@GetMapping("/newrole")
	public String newRole() {
		return "NewRole";
	}

	@PostMapping("/saverole")
	public String saveRole(RoleEntity role) {
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
	
    @GetMapping("/deleterole")
    public String deleteRole(@RequestParam("roleId") Integer roleId) {
    	r.deleteById(roleId);
    	return "redirect:/listrole";
    }

}
