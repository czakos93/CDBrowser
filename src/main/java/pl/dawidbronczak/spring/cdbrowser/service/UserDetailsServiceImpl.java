package pl.dawidbronczak.spring.cdbrowser.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.dawidbronczak.spring.cdbrowser.dao.UserDao;
import pl.dawidbronczak.spring.cdbrowser.domain.User;
import pl.dawidbronczak.spring.cdbrowser.domain.UserRole;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserDao userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		User user = userDao.getUserByName(userName);
		List<GrantedAuthority> authorities  = buildUserAuthority(user.getUserRole());
		return buildUserForAuthentication(user, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Set<UserRole> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		for (UserRole userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}

		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);

		return result;
	}
	
	private org.springframework.security.core.userdetails.User buildUserForAuthentication(User user, List<GrantedAuthority> authorities) {
			return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), 
				user.isEnable(), true, true, true, authorities);
	}
	
	private void addUserToDB(User userToAdd){
		userDao.addUser(userToAdd);
	}
}
