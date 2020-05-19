package io.amanproject.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.amanproject.entities.Task;
import io.amanproject.entities.User;
import io.amanproject.repositories.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public void addTask(Task task, User user){
		task.setUser(user);
		taskRepository.save(task);
	}
	
	//to get all the task in the profile page
	public List<Task> findUserTask(User user){
		return taskRepository.findByUser(user);
	}
	
	public void addTask1(@Valid Task task) {
		taskRepository.save(task);
	}
}