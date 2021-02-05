<%@page import="com.customerapp.customer.Customer"%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show all customers</title>
</head>
<body>
Welcome ${user.username}<br>!
<a href="logout">logout</a>
<br>
<%
	List<Customer> customers=(List<Customer>)request.getAttribute("customers");
	for(Customer customer: customers){
		out.print(customer +"<br>");
	}
%>
<a href="custcontroller.do?action=add">add customer</a>
</body>
</html>