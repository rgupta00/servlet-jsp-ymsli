<%@page import="javax.websocket.Session"%>
<%@page import="com.customerapp.dao.user.User"%>
<%@page import="com.customerapp.customer.Customer"%>
<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>show all customers</title>
<link href="bootstrap/css/bootstrap.css" rel="stylesheet" type="text/css"/>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
</head>
<body>

	Welcome ${user}
	<br>!
	<a href="logout">logout</a>
	<br>
	<div class="row">
    <div class="col-sm-8">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>address</th>
				<th>mobile</th>
				<th>email</th>
				<th>dob</th>
				<c:if test="${user.profile == 'admin'}">
				<th>delete</th>
				<th>update</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td><c:out value="${customer.id }" /></td>
					<td><c:out value="${customer.name}" /></td>
					<td><c:out value="${customer.address}" /></td>
					<td><c:out value="${customer.mobile}" /></td>
					<td><c:out value="${customer.email}" /></td>
					<td><fmt:formatDate pattern="dd/MM/yyyy" value="${customer.dob }" /></td>
					<c:if test="${user.profile == 'admin'}">
					<td><a href="custcontroller.do?action=delete&id=<c:out value="${customer.id }"/>">delete</a></td>
					<td><a href="custcontroller.do?action=update&id=<c:out value="${customer.id }"/>">update</a></td>
					</c:if>
				</tr>
			</c:forEach>
		</tbody>
	</table>
    </div>
 </div>  
<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">
	<a href="custcontroller.do?action=add">add customer</a>
</c:if>

<br>

</body>
</html>