package com.certainhackathon.common.services;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Repository;


@Repository
public class WebAppServiceFactory implements ApplicationContextAware {

	private static ApplicationContext theContext;
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		
		WebAppServiceFactory.theContext = context;
	}	
	
	
}
