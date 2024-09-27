package com.springproject.main;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		Class[] classes = new Class[] {ServletConfig.class};
		return classes;
	}

	@Override
	protected String[] getServletMappings() {
		String[] str = new String[] {"/"};
		return str;
	}
	
}