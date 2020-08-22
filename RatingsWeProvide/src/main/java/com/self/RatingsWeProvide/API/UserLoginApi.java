package com.self.RatingsWeProvide.API;

import org.springframework.http.ResponseEntity;

import com.self.RatingsWeProvide.Model.User;
import com.self.RatingsWeProvide.Service.UserLoginService;

public interface UserLoginApi {

	public ResponseEntity<User> register(User user) throws Exception;
}
