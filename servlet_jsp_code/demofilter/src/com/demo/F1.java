package com.demo;

import java.io.IOException;
import java.util.Random;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class F1 implements Filter {

    public F1() {}

    public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
    
	
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		
		
		System.out.println("i am filter F1");
		System.out.println(req.getRequestURI());
		
		chain.doFilter(request, response);
		
	}

	public void destroy() {
		// TODO Auto-generated method stub
	}


}
