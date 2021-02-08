package com.customerapp.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.customerapp.dao.user.User;

public class SecurityFilter implements Filter {
	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		boolean isLogin = false;

		HttpSession httpSession = req.getSession(false);

		if (httpSession != null) {
			User user = (User) httpSession.getAttribute("user");
			if (user != null) {
				isLogin = true;
			}
		}
		if (isLogin) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("login.jsp?error=please login");
		}
	}

	public void destroy() {
	}

}
