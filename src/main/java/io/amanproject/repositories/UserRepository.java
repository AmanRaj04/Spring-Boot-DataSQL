package io.amanproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import io.amanproject.entities.User;

public interface UserRepository extends JpaRepository<User,String>{

	List<User> findByNameLike(String name);



}
