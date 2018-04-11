package pl.dawidbronczak.spring.cdbrowser.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbronczak.spring.cdbrowser.domain.User;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext 
	EntityManager entityManager;
	
	@Override
	@Transactional
	public User getUserByName(String userName) {		
		return entityManager.find(User.class,userName);
	}

	@Override
	@Transactional
	public void addUser(User userToAdd) {
		entityManager.persist(userToAdd);		
	}

}
