package com.web.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletContextLister implements ServletContextListener {

	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("contextInitialized method is called... ");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("contextDestroyed method is called... ");
	}

}
