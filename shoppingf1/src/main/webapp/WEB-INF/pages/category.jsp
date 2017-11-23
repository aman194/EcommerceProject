<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category Page</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.6/angular.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="index">Sivam</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="index">Home</a></li>
      <li><a href="addCategory">Add New Category</a></li>
      <li ><a href="#">Contact</a></li>
      <li><a href="#">About</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
		
<div class="container">
  <h2>Category Details</h2>
  <p>List</p>
              
  <table class="table table-bordered">
    <thead>
      <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Edit</th>
        <th>Delete</th>
      </tr>
    </thead>
	<c:forEach items="${clist}" var="ca">
		<tr>
				<td>${ca.cid }</td>
				<td>${ca.name }</td>
				<td bgcolor="white"><a href="edit/${ca.cid}">Edit</a></td>
				<td bgcolor="white"><a href="edit/${ca.cid}">Delete</a></td>
		</tr>
	</c:forEach>
	
	</table>
	</div>
</body>
</html>