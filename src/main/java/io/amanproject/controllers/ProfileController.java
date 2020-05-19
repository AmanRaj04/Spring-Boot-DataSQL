package io.amanproject.controllers;

import java.security.Principal;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import io.amanproject.entities.User;
import io.amanproject.services.TaskService;
import io.amanproject.services.UserService;

@Controller
public class ProfileController {

	
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;
	
	@GetMapping("/profile")
	public String showProfilePage(Model model, Principal principal) {
	
		String email=principal.getName();
		Optional<User> ue = userService.findOne(email);
		User user= ue.get();
		model.addAttribute("tasks", taskService.findUserTask(user));//to find user

		//model.addAttribute("tasks", user);//to find user
		return "views/profile";
	}
	
}
