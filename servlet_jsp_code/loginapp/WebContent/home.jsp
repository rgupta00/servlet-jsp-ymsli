<%@page import="com.loginapp.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>book store application</title>
</head>
<body>
<h1>welcome to book store application</h1>
<%
	User user=(User)request.getAttribute("user");
	out.print(user.getUsername()+"<br>");
	out.print(user.getProfile()+"<br>");
%>
</body>
</html>