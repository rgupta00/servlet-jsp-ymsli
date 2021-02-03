package com.iris.bookapp.web.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class DbDriverLodingListner implements ServletContextListener {

 
    public void contextInitialized(ServletContextEvent event)  { 
    	String driver=event.getServletContext().getInitParameter("driver");
    	try {
			Class.forName(driver);
			System.out.println("driver is loaded...");
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
    }
    
    public void contextDestroyed(ServletContextEvent event)  { 
         
    }

	
}
