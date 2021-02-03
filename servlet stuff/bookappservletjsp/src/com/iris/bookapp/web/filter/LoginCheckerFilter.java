package com.iris.bookapp.web.filter;

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

import com.iris.bookapp.model.persistance.user.User;

@WebFilter(urlPatterns="*.do")
public class LoginCheckerFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse res=(HttpServletResponse) response;
		System.out.println("i am in filter f1");
		boolean isValid=false;
		
		String uri=req.getRequestURI();
		
		String lastUriVal=uri.substring(uri.lastIndexOf("/")+1);
		System.out.println(lastUriVal);

		HttpSession httpSession=req.getSession(false);
		
		if(httpSession!=null){
			User user=(User) httpSession.getAttribute("user");
			if(user!=null){
				isValid=true;
			}
		}
		
		
		if(isValid){
		chain.doFilter(request, response);
		}else{
			
			res.sendRedirect("index.jsp");
			return ;
		}
	}

	public void destroy() {
		
	}

}
