<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Items</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">

<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>
<nav class="navbar navbar-default">

	<a href="/" class="navbar-brand">Home</a>

	<ul class="nav navbar-nav">
		<li><a href="/listItem.action">Items</a></li>
		<li><a href="http://www.google.com">Google.com</a></li>
	</ul>
	<ul class="nav navbar-nav navbar-right">
		<li><a href="/logout.action">Logout</a></li>
	</ul>
</nav>


<div class="container">
	<p>
		<font color="red">${errorMessage}</font>
	</p>
	<form action="<c:url value = "/login.action"/>" method="post">
		Please enter your name <input type="text" name="name" /><br/>
		Please enter your password <input type="password" name="password" /> <br/>
		<input type="submit" value="Login" />
	</form>

</div>


<footer class="footer">
	<p>@ nucl</p>
</footer>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>

</html>