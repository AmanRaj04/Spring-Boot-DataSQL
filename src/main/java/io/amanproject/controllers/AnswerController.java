package io.amanproject.controllers;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.amanproject.entities.User;
import io.amanproject.services.ResponseService;
import io.amanproject.services.UserService;

@Controller
public class AnswerController {

	@Autowired
	private ResponseService responseService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/answer")
	public String showAnswerPage(Model model, Principal principal) {
	
		String email=principal.getName();
		Optional<User> ue = userService.findOne(email);
		User user= ue.get();
		model.addAttribute("responses", responseService.findUserResponse(user));//to find user

		//model.addAttribute("tasks", user);//to find user
		return "views/answer";
	}
}
