package io.getarrays.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.getarrays.userservice.entity.Role;
import io.getarrays.userservice.entity.User;
import io.getarrays.userservice.service.UserService;
import lombok.Data;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
	}
	
	@PostMapping("/add/user")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		return new ResponseEntity<>(userService.saveUser(user),HttpStatus.OK);
	}
	
	@PostMapping("/add/role")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		return new ResponseEntity<>(userService.saveRole(role),HttpStatus.OK);
	}
	
	@PostMapping("/add/role/to/user")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser roleToUser){
		userService.addRoleToUser(roleToUser.getUsername(), roleToUser.getRolename());
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
@Data
class RoleToUser{
	private String username;
	private String rolename;
}
