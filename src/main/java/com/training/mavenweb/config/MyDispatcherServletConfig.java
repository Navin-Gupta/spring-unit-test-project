package com.training.mavenweb.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyDispatcherServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	//suppose to return an array of application context configuration classes(reflections)
	//classes responsible for config bean container
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	//suppose to return array of classes(reflections) : servlet helper classes
	//eg: class that would be created in alt to dispatcher-servlet.xml
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { DispatcherServletHelperConfig.class };
	}

	//return a string array of url mapping
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}

}
