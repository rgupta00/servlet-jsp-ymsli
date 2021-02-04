<%@ page language="java" 
import="java.util.*, java.sql.*"
contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>suggested books</title>
</head>
<body>

<%
	List<String> booksNames=(List<String> )request.getAttribute("booksNames");
	for(String booksName: booksNames){
		out.print(booksName +"<br>");
		
		
	}
%>
<br>
<a href="select.html">want more suggestion?</a>
YMSLI
</body>
</html>