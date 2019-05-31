package com.training.mavenweb.config;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration  //register this class as config class
@EnableWebMvc   //enable mvc related support
@ComponentScan(basePackages="com.training.mavenweb") //packages to scanfor beans
@PropertySource("classpath:database.properties")
public class DispatcherServletHelperConfig {
	
	@Autowired
	private Environment env;
	
	
	@Bean
	public DataSource securityDataSource() {
		
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		
		//set the DB Driver
		try {
			dataSource.setDriverClass(this.env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//set jdbc connection properties
		dataSource.setJdbcUrl(this.env.getProperty("jdbc.url"));
		dataSource.setUser(this.env.getProperty("jdbc.username"));
		dataSource.setPassword(this.env.getProperty("jdbc.password"));
		
		//set connection pool properties
		dataSource.setInitialPoolSize(Integer.parseInt(this.env.getProperty("connection.pool.initialPoolSize")));
		dataSource.setMinPoolSize(Integer.parseInt(this.env.getProperty("connection.pool.minPoolSize")));
		dataSource.setMaxPoolSize(Integer.parseInt(this.env.getProperty("connection.pool.maxPoolSize")));
		dataSource.setMaxIdleTime(Integer.parseInt(this.env.getProperty("connection.pool.maxIdleTime")));
		
		//return dataSource
		return dataSource;
	}
	
	
	@Bean
	public ViewResolver viewReslover() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		
		//inject dependency
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
}
