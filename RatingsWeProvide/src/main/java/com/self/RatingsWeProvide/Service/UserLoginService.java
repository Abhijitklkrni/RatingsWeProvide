package com.self.RatingsWeProvide.Service;

import org.springframework.stereotype.Service;

import com.self.RatingsWeProvide.Model.User;


public interface UserLoginService {

	public long register(User user) throws Exception;

	public User getUser(long regId);

}
