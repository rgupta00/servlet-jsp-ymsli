<%@page import="com.loginapp.model.User"%>
<%@ page language="java" import="java.util.*"

contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>all books</title>
</head>
<body>
<%
	User user=(User)session.getAttribute("user");
	out.print(user.getUsername()+"<br>");
	out.print(user.getProfile()+"<br>");
%>
<a href="logout">logout</a><br>
<%
	List<String> books=(List<String>)request.getAttribute("books");
	for(String book: books){
		out.print(book+"<br>");
	}
%>
<br>
</body>
</html>