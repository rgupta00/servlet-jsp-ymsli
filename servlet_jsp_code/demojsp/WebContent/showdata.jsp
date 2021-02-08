<%@page import="com.demo.Person"%>
<%@page import="com.demo.Dog"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showdata</title>
</head>
<body>

<c:set var="salary" value="5000" scope="session"></c:set>
<c:out value="${salary}"></c:out><br>
<c:remove var="salary"/>
<c:out value="${salary}"></c:out><br>



<c:forEach items="${books}" var="book">
	<c:out value="${book}"></c:out><br>
</c:forEach>

<!-- EL expression language jsp 2.x: safe evaluation?  -->
<%-- ${sessionScope.person.dog.dogName}<br>
${footballList[0] }<br>
${footballList["2"] }<br>
${footballList }<br>


${foodMap.HotDrink }<br>
${foodMap["TakeAway"]}<br>
${foodMap[foodTypes[3]]}<br> --%>
</body>
</html>