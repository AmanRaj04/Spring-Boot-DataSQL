package io.amanproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import io.amanproject.entities.Role;


public interface RoleRepository extends JpaRepository<Role, String>{

}
