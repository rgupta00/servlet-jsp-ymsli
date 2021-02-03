<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add/Update Book</title>
</head>
<body>

<form action="BookController.do" method="post">
	<input type="text" name="id" value="<c:out value="${book.id }"/>"><br/>
  Enter isbn:<input type="text" name="isbn" value="<c:out value="${book.isbn }"/>"/><br/>
  Enter title:<input type="text" name="title" value="<c:out value="${book.title }"/>"/><br/>
  Enter author:<input type="text" name="author" value="<c:out value="${book.author }"/>"/><br/>
  Enter price:<input type="text" name="price" value="<c:out value="${book.price }"/>"/><br/>
  Enter pubDate:<input type="text" name="pubDate" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${book.pubDate }" />"/><br/>
  <input type="submit"/>
  
</form>
</body>
</html>