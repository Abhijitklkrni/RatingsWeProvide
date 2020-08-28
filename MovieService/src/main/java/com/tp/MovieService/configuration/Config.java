package com.tp.MovieService.configuration;


import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.tp.MovieService.Service com.tp.MovieService.DAO com.tp.MovieService.Entity")
public class Config {

	// It will automatically read database properties from application.properties and create DataSource object
	@Autowired
	private DataSource dataSource;    

	
	 @Autowired
	 @Bean(name ="sessionFactory") public LocalSessionFactoryBean
	  getSessionFactory() { // creating session factory LocalSessionFactoryBean
	  LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	  sessionFactory.setDataSource(dataSource);
	  sessionFactory.setPackagesToScan(new String[]{"com.tp.MovieService.Entity"});
	  sessionFactory.setHibernateProperties(hibernateProperties()); return
	 sessionFactory; }
	 

	private Properties hibernateProperties()
	{ 
		// configure hibernate properties
		Properties properties = new Properties(); 
		properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "false");
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties; 
	}


	/*
	 * @Bean public DataSource getDataSource() { DataSourceBuilder dataSourceBuilder
	 * = DataSourceBuilder.create();
	 * dataSourceBuilder.driverClassName("oracle.jdbc.OracleDriver");
	 * dataSourceBuilder.url("jdbc:oracle:thin:@localhost:1521:orcl");
	 * dataSourceBuilder.username("scott"); dataSourceBuilder.password("tiger");
	 * return dataSourceBuilder.build(); }
	 */
	
	  @Autowired 
	  @Bean(name = "transactionManager") // creating transaction manager factory
	  public HibernateTransactionManager getTransactionManager( SessionFactory
	  sessionFactory) { HibernateTransactionManager transactionManager = new
	  HibernateTransactionManager(sessionFactory); return transactionManager;
	  
	  }
	 


}


