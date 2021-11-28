<%@ include file="header.jsp" %>
<div class="container mt-5">
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Description</th>
      <th scope="col">Target Date</th>
      <th scope="col">Status</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${todos}" var="todo">
   <tr>
      <td>${todo.getDesc()}</td>
      <td><fmt:formatDate value="${todo.getDate()}" pattern="dd/MM/yyyy"/></td>
      <td>${todo.isDone()}</td>
      <td><a href="/update-todo?id=${todo.getId()}"><button type="button" class="btn btn-info">Update</button></a></td>
      <td><a href="/delete-todo?id=${todo.getId()}"><button type="button" class="btn btn-danger">Delete</button></a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<a href="/add-todo"><button type="button" class="btn btn-primary">Add a ToDo</button></a>
</div>
<%@ include file="footer.jsp" %>