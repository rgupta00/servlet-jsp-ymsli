<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login application</title>
</head>
<body>
<!-- EL Expression languge -->
${param.error}<br>
${param.message }<br>
<br>
<form action="loginController" method="post">
	Enter name : <input type="text" name="username"/><br>
	Enter password : <input type="password" name="password"/><br>
	<input type="submit"/>
</form>
</body>
</html>