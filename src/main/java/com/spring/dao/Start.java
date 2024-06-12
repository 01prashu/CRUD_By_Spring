package com.spring.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Start {
	private ApplicationContext context;
	private ImplementInterfaceDao implDao;
	public ApplicationContext getContext() {
		return this.context = new AnnotationConfigApplicationContext(JavaConfig.class);
	}
	
	public ImplementInterfaceDao getImplDao() {
	
		return this.implDao = (ImplementInterfaceDao) context.getBean("dao", ImplementInterfaceDao.class)
	}
	
	
}
