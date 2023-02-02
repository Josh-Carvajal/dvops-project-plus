<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit your details!</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@include file="component/all_css.jsp" %>
</head>
<body>


</head>
<body style="backgroud-color: #f0f1f2;">
<%@include file="component/navbar.jsp" %>
<div class="conatiner">
	<div class="row p-5">
		<div class="col-md-6 offset-md-3">
			<div class="card">
				<div class="card-body">
					<c:if test="${reminder != null}">
						<form action="update" method="post">
					</c:if>
					<c:if test="${reminder == null}">
						<form action="insert" method="post">
					</c:if>
					<caption>
						<h2>
							<c:if test="${reminder != null}">Edit Reminder</c:if>
							<c:if test="${reminder == null}">Add Reminder</c:if>
						</h2>
					</caption>
					<!--<c:if test="${reminder != null}">
						<input type="hidden" name="oriName" value="<c:out value='${reminder.name}'/>" />
					</c:if>-->
					<fieldset class="form-group">
						<label>Name</label> <input type="text" value="<c:out value='${reminder.name}'/>" class="form-control" name="name" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>Reminder</label> <input type="text" value="<c:out value='${reminder.reminder}'/>" class="form-control" name="reminder">
					</fieldset>
					<fieldset class="form-group">
						<label>Status</label> <input type="text" value="<c:out value='${reminder.status}'/>" class="form-control" name="status">
					</fieldset>
					<fieldset class="form-group">
						<label> Importance</label> <input type="text" value="<c:out value='${reminder.importance}'/>" class="form-control" name="importance">
					</fieldset>
					<fieldset class="form-group">
						<label> Date</label> <input type="text" value="<c:out value='${reminder.date}'/>" class="form-control" name="date">
					</fieldset>
					<button type="submit" class="btn btn-success">Save</button>
<!-- <h3 class="text-center text-success">Edit Tasks</h3>
<form action="" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Task Name</label>
    <input type="text" class="form-control" id="EditTask" aria-describedby="taskHelp" name="Task">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Tasks</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="tasks">
  </div>
<div class="form-group">
      <label for="inputState">Status</label>
      <select id="inputState" class="form-control" name="status">
        <option selected>--Select--</option>
        <option value="Pending">Pending</option>
        <option value="Complete">Complete</option>
      </select>
    </div>
    <div class="form-group">
 <label for="importanceState">Importance</label>
      <select id="importanceState" class="form-control" name="importance">
        <option selected>--Select--</option>
        <option value="oneStar"></option>
        <option value="twoStar"></option>
        <option value="threeStar"></option>
        <option value="fourStar"></option>
        <option value="fiveStar">*</option>
      </select>
      </div>

  <div class="text-center">
  <a href="index.jsp" class="btn btn-sm btn-primary">SAVE EDITED TASK</a>
  </div>

</form>-->
					</form>
				</div>
			</div>
		</div>
	</div>
</div>

</div>
</body>
</html>