package com.training.mavenweb.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration //enable this class as configuration class
@EnableWebSecurity //to enable the security filter to consult security config from this file
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	//create the in-memory user credentials ...
	//special configure method for repo maintainance
	
	//add dependency of dataSource
	@Autowired
	private DataSource dataSource;
	
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		
		//All jdbc code would be generated in background
		auth.jdbcAuthentication().dataSource(this.dataSource);
		
		//custom table schemas
		//placeholder : (?) will auto be initialized by spring from login form
		/*auth.jdbcAuthentication().dataSource(this.dataSource)
			.usersByUsernameQuery("select user_id,pw,active from members where user_id=?")
			.authoritiesByUsernameQuery("select user_id, role from roles where user_id=?");*/
		
		
		//helps to register users with credentials
		/*UserBuilder builder= User.withDefaultPasswordEncoder();
		
		//enable the in-memory auth
		auth.inMemoryAuthentication()  //composable method
			.withUser(builder.username("First").password("abc").roles("EMPLOYEE"))
			.withUser(builder.username("Second").password("abc").roles("EMPLOYEE","MANAGER"))
			.withUser(builder.username("Third").password("abc").roles("EMPLOYEE","ADMIN"));
		*/	

	}
	
	
	//Configure security of web paths,custom login,logout
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		
		
		/*http.authorizeRequests() //define accessibilty rules
			.anyRequest() //all requests
			.authenticated() //must be check for authentication
		.and() //operator method to combine config rule
			.formLogin()   //define the custom login rule
				.loginPage("/mylogin") //url of custom login form
				// ./checkuser : a inbuilt resource would be created by framework which maps to this url 
				.loginProcessingUrl("/checkuser")//url where login credentials would be submitted and validated
				.permitAll() //all user shall have accessibility over login form
		.and()
			.logout() //adds support for logout: will add default url support /logout
			.permitAll();*/
		
		http.authorizeRequests() //define accessibilty rules
			.antMatchers("/").hasRole("EMPLOYEE")
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/manager/**").hasRole("MANAGER")
		.and() //operator method to combine config rule
			.formLogin()   //define the custom login rule
				.loginPage("/mylogin") //url of custom login form
				// ./checkuser : a inbuilt resource would be created by framework which maps to this url 
				.loginProcessingUrl("/checkuser")//url where login credentials would be submitted and validated
				.permitAll() //all user shall have accessibility over login form
		.and()
			.logout() //adds support for logout: will add default url support /logout
			.permitAll()
		.and()
			.exceptionHandling()
				.accessDeniedPage("/access-denied");
		
		
	}
	
}


















