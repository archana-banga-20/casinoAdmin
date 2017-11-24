<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Casino</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="resources/style.css">
</head>
<body>

<nav class="navbar navbar-inverse myNavBar">
  <div>
    <ul class="nav navbar-nav">
       <li><a href="index"><button class=" btnNav myActive">Home</button></a></li>
       <li><a href="register"><button class="btnNav">Register</button></a></li>
       <li><a href="display"><button class="btnNav">UserList</button></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="displayHeading">Welcome To Casino Admin App!</li>
    </ul>
  </div>
</nav>
<div>
	<img src="/images/casinohome.jpg" style="height: 520px;width:100%;">
</div>



</body>
</html>