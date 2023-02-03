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
<h3 class="text-center text-caution">Add Reminder</h3>
<form action="AddTaskServlet" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="username">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Reminder</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="tasks">
  </div>
	<div class="form-group">
      <label for="inputState">Status</label>
      <select id="inputState" class="form-control" name="status">
        <option selected>-Select-</option>
        <option value="Pending">Pending</option>
        <option value="Complete">Complete</option>
      </select>
    </div>
    <div class="form-group">
      <label for="inputState">Importance</label>
      <select id="inputState" class="form-control" name="importance">
        <option selected>-Select-</option>
        <option value="Low">Low Importance</option>
        <option value="Medium">Medium Importance</option>
        <option value="High">High Importance</option>
      </select>
    </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Date</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="date">
  </div>

  
  <div class="text-center">
  <button type="submit" class="btn btn-sm btn-primary">ADD TASK</a>
  
  </div>
  
</form>
</div>
</div>
</div>
</div>
</div>


</body>
</html>