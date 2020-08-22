package com.tp.MovieService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tp.MovieService.DAO.UserDetailsProviderDAO;
import com.tp.MovieService.model.UserDetailsBean;

@Transactional(readOnly = true)
@Service
public class UserDetailsProviderService {

	
	@Autowired
	UserDetailsProviderDAO userDetailsProvideDAO;
	
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public UserDetailsBean getUserDetailsFromDB(String userName) {
		System.out.println("3");
		try {
			return userDetailsProvideDAO.getUserDetailsFromDB(userName);
			
		}catch(Exception e )
		{
			System.out.println("6");
			e.printStackTrace();
		}
		return null;
	}
	
	public String getLockedStatus(String userName) {
		return null;
	}
	
	public String getExpiredStatus(String userName) {
		return null;
	}

}
