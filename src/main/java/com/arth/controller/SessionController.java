package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.UserEntity;
import com.arth.repository.UserRepository;


@Controller
public class SessionController {
	
	@Autowired
	UserRepository u;
	
	@GetMapping("/")
	public String welcome() {
		return "Welcome";
	}
	
	@GetMapping("/signup")
	public String signup() {
		return "Signup";
	}
	
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@PostMapping("/signup")
	public String saveUser(UserEntity user) {
		user.setRoleId(3);
		u.save(user);
		return "redirect:/login";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(UserEntity user, Model model) {
		UserEntity loggedInUser = u.findByEmailAndPass(user.getEmail(), user.getPass());
		System.out.println(loggedInUser);
		
		if(loggedInUser == null) {
			model.addAttribute("error", "Invalid Email or Password!");
			return "Login";
		}else {
			if(loggedInUser.getRoleId() == 1) {
				//admin
				return "AdminDashboard";
			}else if (loggedInUser.getRoleId() == 2) {
				//manager
				return "ProjectManagerDashboard";
			} else if (loggedInUser.getRoleId() == 3) {
				// developer
				return "DeveloperDashboard";
			}	
		}	
		return "Login";
	}
		
	
}
