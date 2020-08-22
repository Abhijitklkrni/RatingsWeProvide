package com.self.RatingsWeProvide.DAO;

import com.self.RatingsWeProvide.Model.User;

public interface UserLoginDao {

	public long registerUser(User user);
	
	public User getUser(long regId); 
	
}
