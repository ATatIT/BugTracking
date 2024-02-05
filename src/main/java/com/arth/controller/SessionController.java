package com.arth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.bean.UserBean;

@Controller
public class SessionController {
	
	@GetMapping("/welcome")
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
		
	@PostMapping("/saveuser")
	public String saveUser(UserBean user) {
		
		System.out.println(user.getFirstname());
		System.out.println(user.getLastname());
		System.out.println(user.getEmail());
		System.out.println(user.getPass());
		return "Home";
	}
}
