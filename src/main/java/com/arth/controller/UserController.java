package com.arth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.arth.entity.RoleEntity;
import com.arth.entity.UserEntity;
import com.arth.repository.RoleRepository;
import com.arth.repository.UserRepository;
import com.arth.service.MailerService;

@Controller
public class UserController {
	@Autowired
	UserRepository u;

	@Autowired
	RoleRepository roleRepo;

	@Autowired
	BCryptPasswordEncoder encoder;

	@Autowired
	MailerService mailerservice;

	@GetMapping("/newuser")
	public String newUser(Model model) {
		List<RoleEntity> roleList = roleRepo.findAll();
		model.addAttribute("roleList", roleList);
		return "NewUser";
	}

	@PostMapping("/saveuser")
	public String saveUser(UserEntity user, Model model) {

		if (!user.getPass().equals(user.getConfirmPassword())) {
			model.addAttribute("confirmpassword", "Password & ConfirmPassword must be same");
			return "NewUser";
		}

		// get plain passsword
		String plainPassword = user.getPass();

		// encrypt plainpassword
		String ecodedPassworg = encoder.encode(plainPassword);

		// set the password
		user.setPass(ecodedPassworg);

		u.save(user);
		mailerservice.sendWelcomeMassage(user.getEmail(), user.getFirstName());
		return "redirect:/listuser";
	}

	@GetMapping("/listuser")
	public String listUser(Model model) {
		List<UserEntity> users = u.findAll();
		model.addAttribute("u", users);
		return "ListUser";
	}

	@GetMapping("/deleteuser")
	public String deleteUser(@RequestParam("userId") Integer user) {
		u.deleteById(user);
		return "redirect:/listuser";
	}

	@GetMapping("/table")
	public String table() {
		return "Table";
	}
}
