package com.customerapp.listners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionCounterListner implements HttpSessionListener {
	public long counter=0;
	
    public void sessionCreated(HttpSessionEvent se)  { 
        counter++;
        System.out.println("added: "+ counter);
    }

	
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	 counter--;
    	 System.out.println("removed: "+ counter);
    }
	
}
