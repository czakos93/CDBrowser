package pl.dawidbronczak.spring.cdbrowser.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.cdbrowser.dao.UserDao;
import pl.dawidbronczak.spring.cdbrowser.domain.User;
import pl.dawidbronczak.spring.cdbrowser.domain.UserRole;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	UserRoleService userRoleService;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@Override
	public void registerUser(User newUser) {
		newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
		newUser.setEnable(true);
		userDao.addUser(newUser);
		UserRole userRole = new UserRole();
		userRole.setUser(newUser);
		userRole.setRole("ROLE_USER");
		userRoleService.addUserRole(userRole);
		
	}

}
