package io.getarrays.userservice;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.getarrays.userservice.entity.Role;
import io.getarrays.userservice.entity.User;
import io.getarrays.userservice.service.UserService;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(UserService userService) {
		return args ->{
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			
			userService.saveUser(new User(null, "Shekhar Thandra", "Shekhar", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Vani Thandra", "Vani", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Udhbhav Thandra", "udhbhav", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Keerthana Thandra", "Keerthana", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "Rasagna Thandra", "Rasagna", "1234", new ArrayList<>()));
			
			userService.addRoleToUser("Shekhar", "ROLE_USER");
			userService.addRoleToUser("Shekhar", "ROLE_MANAGER");
			userService.addRoleToUser("udhbhav", "ROLE_ADMIN");
			userService.addRoleToUser("udhbhav", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("Vani", "ROLE_MANAGER");
			userService.addRoleToUser("Keerthana", "ROLE_USER");
			userService.addRoleToUser("Rasagna", "ROLE_USER");
		};
	}

}
