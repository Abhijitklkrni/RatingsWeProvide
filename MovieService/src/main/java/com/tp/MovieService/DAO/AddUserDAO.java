package com.tp.MovieService.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tp.MovieService.Entity.AuthoritiesEntity;
import com.tp.MovieService.Entity.UserDetailsEntity;
import com.tp.MovieService.model.UserDetailsBean;

@Repository
public class AddUserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public String addNewUser(UserDetailsBean udb) {
		Session session = sessionFactory.getCurrentSession();
		
		UserDetailsEntity ude = new UserDetailsEntity();
		ude.setUserName(udb.getUserName());
		ude.setPassword(udb.getPassword());
		ude.setLocked(udb.getLocked());
		ude.setExpired(udb.getExpired());
		return (String) session.save(ude);
	}

	public int grantAccess(String userName, String authority) {
		Session session = sessionFactory.getCurrentSession();
		AuthoritiesEntity ae = new AuthoritiesEntity();
		ae.setUserName(userName);
		ae.setAuthority(authority);
		return (int) session.save(ae);
	}

	public int changePassword(String userName, String password) throws Exception {
		Session session = sessionFactory.getCurrentSession();
		UserDetailsEntity ude = (UserDetailsEntity)session.get(UserDetailsEntity.class, userName);
		if(ude!= null) 
		{
		if(ude.getPassword().equals(password)) throw new Exception("Old password and new password matches");
		ude.setPassword(password);
		}else throw new Exception("User does not exist");
		return 1;
	}
	
}
