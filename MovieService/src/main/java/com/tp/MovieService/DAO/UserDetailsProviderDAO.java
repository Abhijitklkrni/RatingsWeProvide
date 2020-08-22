package com.tp.MovieService.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tp.MovieService.Entity.AuthoritiesEntity;
import com.tp.MovieService.Entity.UserDetailsEntity;
import com.tp.MovieService.model.UserDetailsBean;

@Repository
public class UserDetailsProviderDAO {

	@Autowired
	SessionFactory sessionFactory; 

	
	public UserDetailsBean getUserDetailsFromDB(String userName) {
		System.out.println("4");
		Session session = sessionFactory.getCurrentSession();
		UserDetailsEntity ude = (UserDetailsEntity) session.get(UserDetailsEntity.class, userName);
		if(ude==null) System.out.println("UserEntity is NULLL");

		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class); 
		Root<AuthoritiesEntity> root = criteriaQuery.from(AuthoritiesEntity.class);
		criteriaQuery.select(root.get("authority"))
					 .where(criteriaBuilder.equal(root.get("userName"), userName)); 
		Query query = session.createQuery(criteriaQuery); 

		List<String> authoritiesList = query.getResultList();
		System.out.println("-------------------------------------------------------");

		for(String a :authoritiesList) { System.out.println(a); }

		System.out.println("-------------------------------------------------------");
		UserDetailsBean udb=null;
		if(ude != null && !authoritiesList.isEmpty()) {
			System.out.println("4.1");
			System.out.println(ude.getPassword());
			udb = new UserDetailsBean();
			udb.setUserName(ude.getUserName());
			udb.setPassword(ude.getPassword());
			udb.setLocked(ude.getLocked());
			udb.setExpired(ude.getExpired());
			udb.setAuthorities(authoritiesList);
		}
		System.out.println("5");
	return udb;
	}
		
}
