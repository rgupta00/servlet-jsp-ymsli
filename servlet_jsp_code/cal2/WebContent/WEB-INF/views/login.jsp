<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
${error}<br>
<form action="login" method="post">
	Enter name : <input type="text" name="username"/><br/>
	Enter password : <input type="password" name="password"/><br/>
	<input type="submit"/>
</form>
</body>
</html>