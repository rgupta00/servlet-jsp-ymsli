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
	User user=(User)session.getAttribute("user");
	out.print(user.getUsername()+"<br>");
	out.print(user.getProfile()+"<br>");
%>
<a href="logout">logout</a><br>
<br>
<a href="addbook">add book</a><br>
<a href="deletebook">del book</a><br>
<a href="update">update book</a><br>
<a href="showall">show all books</a><br>

</body>
</html>





