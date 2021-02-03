<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>result of adding two nos</title>
</head>
<body>

<!-- -scriptlet -->
<%
	Integer sum=(Integer)session.getAttribute("sum");
	out.print(sum + "<br>");
%>
<a href="cal.html">want to add more numbers?</a> 
</body>
</html>