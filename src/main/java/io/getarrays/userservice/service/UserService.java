package io.getarrays.userservice.service;

import java.util.List;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.stereotype.Service;

import io.getarrays.userservice.entity.Role;
import io.getarrays.userservice.entity.User;

@Service
public interface UserService {
	User saveUser(User user);
	Role saveRole(Role role);
	void addRoleToUser(String username,String roleName);
	User getUser(String username);
	List<User> getUsers();
}
