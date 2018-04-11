package pl.dawidbronczak.spring.cdbrowser.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.dawidbronczak.spring.cdbrowser.domain.User;
import pl.dawidbronczak.spring.cdbrowser.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
	public String registrationNewUser(@ModelAttribute("newUser") User newUser){
		return "registration";
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public String proccedRegistrationNewUser(@ModelAttribute("newUser") User newUser){
		userService.registerUser(newUser);
		return "redirect:/";
	}
}
