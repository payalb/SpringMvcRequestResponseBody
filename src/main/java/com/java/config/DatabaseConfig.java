package com.java.config;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement(proxyTargetClass=true)
@PropertySource("classpath:database.properties")
public class DatabaseConfig {

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;
	
	@Value("${spring.datasource.url}")
	private String url;
	
	@Value("${spring.datasource.username}")
	private String username;
	
	@Value("${spring.datasource.password}")
	private String password;
	
	@Value("${spring.jpa.hibernate.dialect}")
	private String dialect;
	
	@Value("${spring.jpa.show-sql}")
	private String showSql;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String hbm2ddl;
	
	@Value("${entitymanager.packagesToScan}")
	private String pkg;
	
	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource ds= new DriverManagerDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverClassName);
		ds.setUsername(username);
		ds.setPassword(password);
		System.out.println(ds);
		return ds;
	}
	/*
	@Bean("transactionManager")
	public HibernateTransactionManager getTransactionManager() {
		HibernateTransactionManager tx= new HibernateTransactionManager();
		tx.setDataSource(getDatasource());
		tx.setSessionFactory(sf().getObject());
		return tx;
	}
	*/

	@Bean("entityManagerFactory")
	@DependsOn("flyway")
	public EntityManagerFactory entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean bean= new LocalContainerEntityManagerFactoryBean();
		bean.setDataSource(getDatasource());
		bean.setPackagesToScan(pkg);
		bean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
		bean.setJpaProperties(properties());
		bean.afterPropertiesSet();
		return bean.getObject();
	}

	
	private Properties properties() {
		Properties p= new Properties();
		//p.setProperty("hibernate.hbm2ddl.auto", hbm2ddl);
		p.setProperty("hibernate.show_sql", showSql);
		p.setProperty("hibernate.dialect", dialect);
		return p;
	}
	
	@Bean
	JpaTransactionManager transactionManager() {
		JpaTransactionManager tx= new JpaTransactionManager();
		tx.setEntityManagerFactory(entityManagerFactory());
		return tx;
	}
	
	
}
