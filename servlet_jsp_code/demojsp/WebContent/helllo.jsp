<%@page import="com.demo.Dog"%>
<%@ page import="java.util.*, java.io.*" 
contentType="text/html; charset=ISO-8859-1" language="java" info="this is hello jsp"
session="true" isThreadSafe="true" isErrorPage="false" errorPage="myerror.jsp"%>
<!-- how to handle the exp! -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello page
<%@ include file="footer.jsp" %>
</body>
</html>