package com.arth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.arth.entity.UserEntity;
import com.arth.repository.UserRepository;
import com.arth.service.MailerService;

import jakarta.servlet.http.HttpSession;


@Controller
public class SessionController {
	
	@Autowired
	UserRepository u;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	@Autowired
	MailerService mailerservice;
	
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
		mailerservice.sendWelcomeMassage(user.getEmail(), user.getFirstName());
		return "redirect:/login";
	}
	
	@PostMapping("/authenticate")
	public String authenticate(UserEntity user, Model model, HttpSession session) {
		UserEntity loggedInUser = u.findByEmail(user.getEmail());
		System.out.println(loggedInUser);
		
		if(loggedInUser == null) {
			model.addAttribute("erroremail", "Invalid Email!");
			return "Login";
		}else {
			
			session.setAttribute("user", loggedInUser);
			session.setMaxInactiveInterval(60*10);
			
			boolean password = encoder.matches(user.getPass(),loggedInUser.getPass());
			if(password == false) {
				model.addAttribute("error", "Invalid Password!");
				return "Login";
			}else if(loggedInUser.getRoleId() == 1) {
				//admin
				return "redirect:/admindashboard";
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
		
	@GetMapping("/forgotpassword")
	public String forgotPassword() {
		return "ForgotPassword";
	}
	
	@PostMapping("/otpforpassword")
		public String otpForPassword(UserEntity user) {
		
		UserEntity dbUser = u.findByEmail(user.getEmail());
		if(dbUser != null) {
			//otp genration & send to email
			int otpnum = (int) (Math.random() * 1000000);
			System.err.println("OTP =>"+otpnum);
			mailerservice.sendMailForOTP(user.getEmail(), otpnum);
			
			
			//set otp
			dbUser.setOtp(otpnum);
			u.save(dbUser);
		}
		return "UpdatePassword";
	}
	
	@PostMapping("/updatepassword")
	public String updatePassword(UserEntity user, Model model) {
		if(!user.getPass().equals(user.getConfirmPassword())) {
			model.addAttribute("confirmpassword", "Password & ConfirmPassword must be same!");
			return "UpdatePassword";
		}else {
			UserEntity dbUser = u.findByEmail(user.getEmail());
			
			if(dbUser == null || dbUser.getOtp().intValue() != user.getOtp().intValue()|| dbUser.getOtp()== -1) {
				model.addAttribute("error", "Invalid OTP & Emial!");
				return "UpdatePassword";
			}else {
				String pailPassword = user.getPass();
				String encryptPassword = encoder.encode(pailPassword);
				dbUser.setPass(encryptPassword);
				dbUser.setOtp(-1);
				u.save(dbUser);
				model.addAttribute("update", "Password Updated Successfully");
			}
		}
		return "Login";
	}
	
	@GetMapping("/logout")
	public String logOut(HttpSession session) {
		session.invalidate();
		return "redirect:/login";
	}
}
