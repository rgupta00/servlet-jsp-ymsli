<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>

<body>

<c:if test="${user.profile == 'admin'}">
   <h1>this is shown if ur admin</h1> 
</c:if>

Welcome user ${user.username } | ${user.profile }<br/>
<a href="LogOutController">logout</a>
<br/><br/>
<div class="container">
  <h1>Hello World!</h1>
  <div class="row">
    <div class="col-sm-8">

	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>isbn</th>
				<th>title</th>
				<th>author</th>
				<th>price</th>
				<th>pubDate</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="book" items="${books}">
			<tr>
				<td><c:out value="${book.id }"/></td>
				<td><c:out value="${book.isbn }"/></td>
				<td><c:out value="${book.title }"/></td>
				<td><c:out value="${book.author }"/></td>
				<td><c:out value="${book.price }"/></td>
				<td><fmt:formatDate pattern="dd/MM/yyyy" value="${book.pubDate }" /></td>
				
				<c:if test="${user.profile == 'admin'}">
					<td><a href="BookController.do?action=update&id=<c:out value="${book.id }"/>">update</a><td>
					<td><a href="BookController.do?action=delete&id=<c:out value="${book.id }"/>">delete</a><td>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
	<a href="BookController.do?action=add">add book</a>
	</c:if>
</div>
</div>
</div>

</body>
</html>







