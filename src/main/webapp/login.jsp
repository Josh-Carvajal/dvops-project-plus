<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="component/all_css.jsp" %>
</head>
<body style="backgroud-color: #f0f1f2;">
<%@include file="component/navbar.jsp" %>
<div class="conatiner">
<div class="row p-5">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<h3 class="text-center text-caution">Login</h3>
<form action="LoginServlet" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Password</label>
    <input type="password" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="password">
  </div>
  
  <div class="text-center">
  <button type="submit" class="btn btn-sm btn-primary">Login</a>
  	<!--  <form action="LoginServlet" method="post">
		<ul>Enter your name: <input type="text" name="userName" size="20"/></ul>
		<ul>Enter your password: <input type="password" name="password" size="20"/></ul>
		<ul><input type="submit" value="Login"/></ul>
	</form>-->
  </div>
  
</form>
</div>
</div>
</div>
</div>
</div>


</body>
</html>