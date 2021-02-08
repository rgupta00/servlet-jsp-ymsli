package com.calapp.web.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.calapp.model.service.User;

@WebFilter("*.do")
public class SecFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		boolean isLoggedIn=false;
		
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		System.out.println("--------------------------------");
		System.out.println("inside doFilter of SecFilter");
		
		//need pre define session
		HttpSession httpSession=req.getSession(false);
		if(httpSession!=null) {
			User user=(User) httpSession.getAttribute("user");
			if(user!=null)
			isLoggedIn=true;
		}
		if(isLoggedIn)
		chain.doFilter(request, response);
		else
			resp.sendRedirect("login");
	}

	public void destroy() {
	}
}
