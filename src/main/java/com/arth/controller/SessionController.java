package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
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
	public String saveUser(UserEntity user, Model model) {
		
		if(!user.getPass().equals(user.getConfirmPassword())){
			model.addAttribute("confirmpassword", "Password & ConfirmPassword must be same");
			return "Signup";
		}
		
		user.setRoleId(3);
		
		//get plain passsword 
		String plainPassword =user.getPass();
		
		//encrypt plainpassword
		String ecodedPassworg = encoder.encode(plainPassword);
		
		//set the password
		user.setPass(ecodedPassworg);
		
		u.save(user);
		return "redirect:/login";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(UserEntity user, Model model) {
		UserEntity loggedInUser = u.findByEmail(user.getEmail());
		System.out.println(loggedInUser);
		
		
		
		
		if(loggedInUser == null) {
			model.addAttribute("erroremail", "Invalid Email!");
			return "Login";
		}else {
			
			boolean password = encoder.matches(user.getPass(),loggedInUser.getPass());
			if(password == false) {
				model.addAttribute("error", "Invalid Password!");
				return "Login";
			}else if(loggedInUser.getRoleId() == 1) {
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
