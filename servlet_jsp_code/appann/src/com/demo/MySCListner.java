package com.demo;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MySCListner implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  { 
        System.out.println("sc is init");
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
    	 System.out.println("sc is destroyed");
    }
	
}
