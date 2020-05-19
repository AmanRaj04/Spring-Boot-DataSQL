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
			User newAdmin=new User("electrical@gmail.com","Electrical","pravega1electrical");
			userService.createAdmin(newAdmin);
			User newAdmin1=new User("powertrain@gmail.com","Power-Train","pravegapowertrain2");
			userService.createAdmin(newAdmin1);
			User newAdmin2=new User("daq@gmail.com","DAQ","pravega1daq1");
			userService.createAdmin(newAdmin2);
			User newAdmin3=new User("vd@gmail.com","VD","1pravegavd1");
			userService.createAdmin(newAdmin3);
			User newAdmin4=new User("composite@gmail.com","Composite","1pravega1composite1");
			userService.createAdmin(newAdmin4);
			User newAdmin5=new User("aero@gmail.com","Aero","1pravegaaero11");
			userService.createAdmin(newAdmin5);
			User newAdmin6=new User("design@gmail.com","Design","1pravegadesign11");
			userService.createAdmin(newAdmin6);
		}
	}
}
