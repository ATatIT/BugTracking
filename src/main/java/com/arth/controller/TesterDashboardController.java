package com.arth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesterDashboardController {
	@GetMapping("/testerdashboard")
	public String testerDashboard() {
		return "TesterDashboard";
	}
}
