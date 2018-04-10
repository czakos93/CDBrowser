package pl.dawidbronczak.spring.cdbrowser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	
	@RequestMapping("/register")
	public String registerUser(){
		return "register";
	}
}
