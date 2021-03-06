package io.amanproject.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.amanproject.entities.User;
import io.amanproject.services.UserService;

@Controller
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String registerform(Model model) {
		model.addAttribute("user", new User());
		return "views/registerform";
	}
	
	@PostMapping("/register")
	public String registerUser(@Valid User user, BindingResult bindingResult, Model model) {
		if(bindingResult.hasErrors())
			return "views/registerform";
		else if(userService.isUserPresent(user.getEmail())) {
			model.addAttribute("exist", true);
			return "views/registerform";
		}
		else{
			userService.createUser(user);
			return "views/sucess";
			}
	}
}
