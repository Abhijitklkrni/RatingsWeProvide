package com.tp.MovieService.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.tp.MovieService.DAO.AddUserDAO;
import com.tp.MovieService.model.UserDetailsBean;

@Transactional(readOnly = true)
@Service
public class AddUserService {

	@Autowired
	AddUserDAO adduserDAO;
	
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public String addNewUser(UserDetailsBean udb) {
		String userName="UserNotPersisted";
		try {
			 userName = adduserDAO.addNewUser(udb); 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return userName;
	}

	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public int grantAccess(String userName, String authority) {
		try {
		int a= adduserDAO.grantAccess(userName,authority);
		
		return a; 
	}catch(Exception e) {
		e.printStackTrace();
		return 0;
	}
}
	@Transactional(readOnly = false,propagation = Propagation.REQUIRES_NEW)
	public int changePassword(String userName, String password) throws Exception {
		try{int a = adduserDAO.changePassword(userName,password);
		return a;
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
