package pl.dawidbronczak.spring.cdbrowser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dawidbronczak.spring.cdbrowser.dao.UserRoleDao;
import pl.dawidbronczak.spring.cdbrowser.domain.UserRole;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	UserRoleDao userRoleDao;
	
	@Override
	public void addUserRole(UserRole newUserRole) {
		userRoleDao.addUserRole(newUserRole);

	}

}
