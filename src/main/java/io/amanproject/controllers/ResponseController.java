package io.amanproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.amanproject.entities.Response;
import io.amanproject.entities.User;
import io.amanproject.services.ResponseService;

@Controller
public class ResponseController {

	@Autowired
	private ResponseService responseService;
	
	@GetMapping("/addans")
	public String ansForm(String email, Model model, HttpSession session){
	
		session.setAttribute("email", email);
		model.addAttribute("response", new Response());
		return "views/ansForm";
	}
	
	@PostMapping("/addans")
	public String addTaskans(@Valid Response response, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors())
			return "views/ansForm";
		String email = (String) session.getAttribute("email");
		//taskService.addTask(task, userService.findemailperson(email));
		response.setUser(new User(email,"",""));
		responseService.addResponse1(response);
		
		return "redirect:/response";
}
}
