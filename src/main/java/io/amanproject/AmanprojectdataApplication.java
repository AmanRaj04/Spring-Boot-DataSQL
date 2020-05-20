package io.amanproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.amanproject.entities.User;
import io.amanproject.services.UserService;

@SpringBootApplication
public class AmanprojectdataApplication implements CommandLineRunner{

	
	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(AmanprojectdataApplication.class, args);
	}

	public void run(String... args) throws Exception{
		{
			User newAdmin=new User("admin@gmail.com","Admin","123456");
			userService.createAdmin(newAdmin);
			
		}
	}
}
