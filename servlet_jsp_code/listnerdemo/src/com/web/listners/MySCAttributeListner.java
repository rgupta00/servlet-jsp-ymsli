package com.web.listners;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class MySCAttributeListner implements ServletContextAttributeListener {

    public void attributeAdded(ServletContextAttributeEvent scae)  { 
         System.out.println("this is going to be called when att was added");
    }

    public void attributeRemoved(ServletContextAttributeEvent scae)  { 
    	 System.out.println("this is going to be called when att was remoted");
    }

	
    public void attributeReplaced(ServletContextAttributeEvent scae)  { 
    	 System.out.println("this is going to be called when att was update/replaced");
    }
	
}
