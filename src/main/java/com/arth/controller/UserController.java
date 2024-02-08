package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.UserEntity;
import com.arth.repository.UserRepository;

@Controller
public class UserController {
	@Autowired
	UserRepository u;

	@GetMapping("/users")
	public String user() {
		return "User";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user) {

		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPass());

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
