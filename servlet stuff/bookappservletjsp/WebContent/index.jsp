<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${loginerror }
<c:remove var="loginerror"/> 
<form action="UserController" method="post">
	Enter userName: <input type="text" name="username"/><br/>
	Enter password: <input type="password" name="password"/><br/>
	<input type="submit"/>
</form>
</body>
</html>