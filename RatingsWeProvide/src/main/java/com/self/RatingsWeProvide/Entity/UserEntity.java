package com.self.RatingsWeProvide.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="UserTable")
@GenericGenerator(name = "idgen",strategy = "increment")
public class UserEntity {

	@Id
	@GeneratedValue(generator="idgen") 
	@Column(name="RegId")
	private long regId;
	
	@Column(name="UserName")
	private String userName;
	
	@Column(name="UserPassword")
	private String password;
	
	@Column(name="EmailId")
	private String emailId;
	
	@Column(name="PhoneNo")
	private String phoneNo;
	
	
	public long getRegId() {
		return regId;
	}
	public void setRegId(long regId) {
		this.regId = regId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	
}
