package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.RoleEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.RoleRepository;
import com.arth.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository u;
	
	@Autowired
	RoleRepository roleRepo;

	@GetMapping("/newuser")
	public String newUser(Model model) {
		List<RoleEntity> roleList =  roleRepo.findAll();
		model.addAttribute("roleList", roleList);
		return "NewUser";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {
		u.save(user);
		return "redirect:/listuser";
	}
	
	@GetMapping("/listuser")
	public String listUser(Model model) {
		List<UserEntity> users = u.findAll();
		model.addAttribute("u", users);
		return "ListUser";
	}
}
