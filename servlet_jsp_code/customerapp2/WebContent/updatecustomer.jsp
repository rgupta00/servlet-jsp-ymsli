<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update existing cutomer</title>

</head>
<body>

<form action="custcontroller.do" method="POST">
	<input type="hidden" name="id" value="${customer.id}" >
	Name: <input type="text" name="name" value="<c:out value="${customer.name }"/>"  readonly/> <br>
	Address: <input name="address" value="${customer.address }" rows="4" cols="20"><br>
	Mobile: <input name="mobile" value="${customer.mobile }"  size="9" /> <br>
	DOB: <input name="dob" size="20" value="<fmt:formatDate pattern="dd/MM/yyyy" value="${customer.dob }" />" readonly/> <br>
	E-mail: <input name="email" value="${customer.email }" size="25" /> <br><br>
	<input type="submit" value="Add" />
	</form>
	
</body>
</html>