<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Integer sum=(Integer)request.getAttribute("sum");
	out.print(sum +"<br>");
%>

<br>
<br>
<a href="logout">logout</a>
</body>
</html>