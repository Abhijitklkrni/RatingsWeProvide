package com.self.RatingsWeProvide.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.provider.HibernateUtils;
import org.springframework.stereotype.Repository;

import com.self.RatingsWeProvide.Entity.UserEntity;
import com.self.RatingsWeProvide.Model.User;

@Repository
public class UserLoginDaoImpl implements UserLoginDao {

	@Autowired
	SessionFactory sessionFactory; 
	
	@Override
	public long registerUser(User user) {
		
		Session session= sessionFactory.getCurrentSession();
		
		UserEntity userEntity=new UserEntity();
		userEntity.setUserName(user.getUserName());
		userEntity.setEmailId(user.getEmailId());
		userEntity.setPhoneNo(user.getPhoneNo());
		userEntity.setPassword(user.getPassword());
		long userId = (long) session.save(userEntity);
		return userId;
	}

	@Override
	public User getUser(long regId) {

		Session session = sessionFactory.getCurrentSession(); 
		System.out.println("REGID :"+regId);
		UserEntity userEntity=(UserEntity)session.get(UserEntity.class,regId);

		User user = new User();

		if(userEntity!=null) 
		{ user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setEmailId(userEntity.getEmailId());
		user.setPhoneNo(userEntity.getPhoneNo()); 
		user.setRegId(userEntity.getRegId());
		}
		else user.setErrorMessage("Entity is null");
		return user;
	}

}
