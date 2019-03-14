package com.cts.grizzlyspring.configuration;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;



import org.hibernate.cfg.Environment.*;
@Configuration
@PropertySource("classpath:db.properties")
@EnableTransactionManagement
@ComponentScans(value={@ComponentScan("com.cts.grizzlyspring.dao"),
		@ComponentScan("com.cts.grizzlyspring.service")
})
public class AppConfig {
	
	@Autowired
	private Environment environment;
	
	@Bean("sessionFactory")
	public org.springframework.orm.hibernate5.LocalSessionFactoryBean getSessionFactory(){
		
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		Properties properties = new Properties();
		properties.put(org.hibernate.cfg.Environment.DRIVER, environment.getProperty("mysql.driver"));
		properties.put(org.hibernate.cfg.Environment.URL, environment.getProperty("mysql.url"));
		properties.put(org.hibernate.cfg.Environment.USER, environment.getProperty("mysql.user"));
		properties.put(org.hibernate.cfg.Environment.PASS, environment.getProperty("mysql.password"));
		
		//hibernate settings
		
		//c3p0
		properties.put(org.hibernate.cfg.Environment.C3P0_MIN_SIZE, environment.getProperty("hibernate.c3p0.min_size"));
		properties.put(org.hibernate.cfg.Environment.C3P0_MAX_SIZE, environment.getProperty("hibernate.c3p0.max_size"));
		properties.put(org.hibernate.cfg.Environment.C3P0_ACQUIRE_INCREMENT, environment.getProperty("hibernate.c3p0.acquire_increment"));
		properties.put(org.hibernate.cfg.Environment.C3P0_TIMEOUT, environment.getProperty("hibernate.c3p0.timeout"));
		properties.put(org.hibernate.cfg.Environment.C3P0_MAX_STATEMENTS, environment.getProperty("hibernate.c3p0.max_statements"));
		properties.put(org.hibernate.cfg.Environment.SHOW_SQL, environment.getProperty("hibernate.show_sql"));
		properties.put(org.hibernate.cfg.Environment.HBM2DDL_AUTO, environment.getProperty("hibernate.hbm2ddl.auto"));
		sessionFactoryBean.setHibernateProperties(properties);
		sessionFactoryBean.setPackagesToScan("com.cts.grizzlyspring.bean");
		
		return sessionFactoryBean;
		
	}
	@Bean
	public org.springframework.orm.hibernate5.HibernateTransactionManager getTransactionManager(){
		org.springframework.orm.hibernate5.HibernateTransactionManager transactionManager= new HibernateTransactionManager();
		transactionManager.setSessionFactory(getSessionFactory().getObject());
		return transactionManager;
		
	}
}
