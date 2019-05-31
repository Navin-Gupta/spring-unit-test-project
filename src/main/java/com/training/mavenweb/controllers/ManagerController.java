package com.training.mavenweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ManagerController {

	@RequestMapping("/manager")
	public String home() {
		return "manager-home";
	}
}
