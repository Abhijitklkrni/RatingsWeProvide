package com.tp.MovieService.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tp.MovieService.Service.AddUserService;
import com.tp.MovieService.model.UserDetailsBean;

@CrossOrigin
@RestController
public class MovieServiceAddUserAPI {

	@Autowired
	AddUserService addUserService;
	
	@RequestMapping(value="addUser",method=RequestMethod.POST)
	public ResponseEntity<String> addUser(@RequestBody UserDetailsBean udb){
		String userName = addUserService.addNewUser(udb);
		
		return new ResponseEntity<String>(userName, HttpStatus.OK);
	}

	@RequestMapping(value="grantAccess/{userName}",method = RequestMethod.POST)
	public ResponseEntity<String> grantAccess(@PathVariable String userName,@RequestParam String authority){
		try {
			if(!authority.startsWith("ROLE_")) throw new Exception("Authority should start with ROLE_");
			int a =addUserService.grantAccess(userName,authority);
			if(a==0) throw new Exception("Error! Authority not Granted");
			return new ResponseEntity<String>("Granted role: "+authority+" to "+userName+" Successfully, with id: "+a,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="changePassword/{userName}",method = RequestMethod.PUT)
	public ResponseEntity<String> changePassword(@PathVariable String userName,@RequestParam String password){
		try {
			int a =addUserService.changePassword(userName,password);
			if(a==0) throw new Exception("Error! Password not changed");
			return new ResponseEntity<String>("Changed Password of "+userName+" Successfully, with id: "+a,HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value="")
	public ResponseEntity<String> welcome(){
				
		return new ResponseEntity<String>("<h1>Welcome</h1>", HttpStatus.OK);
	}

	@RequestMapping(value="/user")
	public ResponseEntity<String> welcomeUser(){
				
		return new ResponseEntity<String>("<h1>Wecome User</h1>", HttpStatus.OK);
	}
	
	@RequestMapping(value="/admin")
	public ResponseEntity<String> welcomeAdmin(){
				
		return new ResponseEntity<String>("<h1>Wecome ADMIN</h1>", HttpStatus.OK);
	}
}
