<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>cutomer application</title>

</head>
<body>
<form action="custcontroller.do" method="POST">
	Name: <input type="text" name="name" /> <br>
	Address: <textarea name="address" rows="4" cols="20"></textarea> <br>
	Mobile: <input name="mobile" size="9" /> <br>
	DOB: <input name="dob" size="20" /> <br>
	E-mail: <input name="email" size="25" /> <br><br>
	<input type="submit" value="Add" />
	</form>
	
</body>
</html>