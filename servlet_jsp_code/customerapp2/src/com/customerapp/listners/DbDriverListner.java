package com.customerapp.listners;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class DbDriverListner implements ServletContextListener {


    public void contextInitialized(ServletContextEvent sce)  { 
        try {
        	Class.forName("com.mysql.jdbc.Driver");
        	System.out.println("----driver loaded----");
        }catch(ClassNotFoundException ex) {
        	
        }
    }
   
    public void contextDestroyed(ServletContextEvent sce)  { 
        
    }

	
}
