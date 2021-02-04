package com.web.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.model.Dog;

public class MyServletContextListner implements ServletContextListener {

	private Dog dog;
	public void contextInitialized(ServletContextEvent sce) {
		
		String dogName=sce.getServletContext().getInitParameter("dogName");
		dog=new Dog(dogName);
		sce.getServletContext().setAttribute("dog", dog);
		
		System.out.println("dog is added to servlet context...");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		sce.getServletContext().removeAttribute("dog");
		System.out.println("dog is remoged form servlet context....");
	}

}
