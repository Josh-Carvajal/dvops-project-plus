

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <a class="navbar-brand" href="<%=request.getContextPath()%>/index.jsp">Reminder</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/ReminderServlet/dashboard">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/add_task.jsp">Add Reminder</a>
      </li>
  
    </ul>
    <form class="form-inline my-2 my-lg-0">
      <a class="nav-link" href="login.jsp">Login <span class="sr-only">(current)</span></a>
    </form>
  </div>
</nav>