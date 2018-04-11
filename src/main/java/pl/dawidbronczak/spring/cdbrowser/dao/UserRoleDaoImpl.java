package pl.dawidbronczak.spring.cdbrowser.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbronczak.spring.cdbrowser.domain.UserRole;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addUserRole(UserRole newUserRole) {
		entityManager.persist(newUserRole);

	}

}
