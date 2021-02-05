<%@page import="com.customerapp.customer.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
success, customer is added to db
<%
	Customer customer=(Customer)session.getAttribute("customer");
	out.print("customer id: "+customer.getId()+"<br>");
	out.print("customer name: "+customer.getName()+"<br>");
	out.print("customer address: "+customer.getAddress()+"<br>");
	out.print("customer email: "+customer.getEmail()+"<br>");
	out.print("customer dob: "+customer.getDob()+"<br>");
%>
</body>
</html>