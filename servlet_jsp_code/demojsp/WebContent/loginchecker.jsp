<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login checker</title>
</head>
<body>
	<jsp:useBean id="ob" class="com.demo.User" scope="request" >
		<jsp:setProperty property="username" name="ob" param="username1"/>
		<jsp:setProperty property="password" name="ob" param="username1" />
	</jsp:useBean>

	<jsp:getProperty property="username" name="ob"/><br>
	<jsp:getProperty property="password" name="ob"/><br>
	<jsp:getProperty property="valid" name="ob"/><br>
	<%-- <jsp:forward page="newpage.jsp"></jsp:forward> --%>
</body>
</html>