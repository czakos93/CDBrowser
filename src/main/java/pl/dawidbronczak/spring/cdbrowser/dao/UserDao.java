package pl.dawidbronczak.spring.cdbrowser.dao;

import pl.dawidbronczak.spring.cdbrowser.domain.User;

public interface UserDao {
	
	User getUserByName(String userName);
	
	void addUser(User userToAdd);
	
}
