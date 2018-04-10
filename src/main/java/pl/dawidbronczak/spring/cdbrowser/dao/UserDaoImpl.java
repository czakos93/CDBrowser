package pl.dawidbronczak.spring.cdbrowser.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import pl.dawidbronczak.spring.cdbrowser.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	public User getUserByName(String userName) {		
		return entityManager.find(User.class,userName);
	}

	@Override
	public void addUser(User userToAdd) {
		// TODO Auto-generated method stub
		
	}

}
