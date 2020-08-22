package com.self.RatingsWeProvide.Validator;

import com.self.RatingsWeProvide.Model.User;

public class UserLoginValidator {

	public static void validate(User user) throws Exception {
		if(!vaidateName(user.getUserName())) throw new Exception("Name should have both first and last name");
		if(!validatePassword(user.getPassword())) throw new Exception("Password does not meet expectations");
		if(!validateEmailId(user.getEmailId())) throw new Exception("Email is not in correct format");
		if(!validatePhoneNo(user.getPhoneNo())) throw new Exception("Phone no. is not in correct format");
	}

	private static boolean validatePhoneNo(String phoneNo) {
		if(phoneNo.length()!=10) return false;
		return true;
	}

	private static boolean validateEmailId(String emailId) {
		if(emailId.matches("[A-z]+.*@.*")) return true;
		return false;
	}

	private static boolean validatePassword(String password) {
		if(password.matches(".*[A-Z].*")) {
			if(password.matches(".*[a-z].*")) {
				if(password.matches(".*[1-9].*")) {
					return true;
				}
					
			}
		}
		return false;
	}

	private static boolean vaidateName(String userName)   {
		if(userName.split(" ").length < 2) return false;
		 return true;
		
	}
}
 