package com.training.mavenweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/mylogin")
	public String login() {
		return "custom-login";
	}
	
	@RequestMapping("/access-denied")
	public String accessDenied() {
		return "access-denied";
	}
}

