package io.amanproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.amanproject.entities.Task;
import io.amanproject.entities.User;


public interface TaskRepository extends JpaRepository<Task, Long>{

	List<Task> findByUser(User user);

}
