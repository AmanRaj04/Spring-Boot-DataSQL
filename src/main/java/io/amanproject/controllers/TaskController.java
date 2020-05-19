package io.amanproject.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.amanproject.entities.Task;
import io.amanproject.entities.User;
import io.amanproject.services.TaskService;

@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;

	
	@GetMapping("/addTask")
	public String taskForm(String email, Model model, HttpSession session){
	
		session.setAttribute("email", email);
		model.addAttribute("task", new Task());
		return "views/taskForm";
	}

	@PostMapping("/addTask")
	public String addTask(@Valid Task task, BindingResult bindingResult, HttpSession session) {
		if(bindingResult.hasErrors())
			return "views/taskForm";
		String email = (String) session.getAttribute("email");
		//taskService.addTask(task, userService.findemailperson(email));
		task.setUser(new User(email,"",""));
		taskService.addTask1(task);
		
		return "redirect:/users";
	}
}