package io.amanproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.amanproject.entities.Response;
import io.amanproject.entities.User;

public interface ResponseRepository extends JpaRepository<Response, Long>{

	List<Response> findByUser(User user);

}
