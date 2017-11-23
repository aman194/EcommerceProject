<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Product</title>
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
      <li><a href="Category">Product</a></li>
      <li ><a href="#">Contact</a></li>
      <li><a href="#">About</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
  </div>
</nav>
		<div class="container">
  <form class="form" action="<%= request.getContextPath() %>/saveProduct" method="post">
    <div class="form-group">
      <label for="name">Name:</label>
      <input type="name" class="form-control" id="name" placeholder="Enter name" name="name" value="${product.name }" >
    </div>
    <div class="form-group">
      <label for="cid">Supplier Id:</label>
      <input type="text" class="form-control" id="cid" placeholder="Enter id" name="cid" value="${product.cid }">
    </div>
    <div class="form-group">
      <label for="description">Description:</label>
      <textarea class="form-control" id="comments" placeholder="Comment" name="desp" rows="5" value="${product.description }"></textarea>
    </div>
    <div class="form-group">
      <label for="price">Price:</label>
      <input type="text" class="form-control" id="price" placeholder="Enter price" name="price" value="${product.price }">
    </div>
    <div class="form-group">
      <label for="stock">Stock:</label>
      <input type="text" class="form-control" id="stock" placeholder="Enter stock" name="stock" value="${product.stock }">
    </div>
    <button type="submit" class="btn btn-default">Submit</button>
    <button type="reset" class="btn btn-default">Reset</button>
  </form>
</div>
</body>
</html>