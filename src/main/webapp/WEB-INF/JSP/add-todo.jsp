<%@ taglib uri = "http://www.springframework.org/tags/form" prefix = "form"%>
<%@ include file="header.jsp" %>
<div class="container mt-5" style="width:1000px;">
<form:form method="post" modelAttribute="todo">
  <div class="form-group">
  	<form:hidden path="id"/>
    <form:label for="exampleFormControlTextarea1" path="desc">Description</form:label>
    <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3" path="desc"></form:textarea>
  	<form:errors path="desc"/>
  	<br>
  	<form:label for="exampleFormControlTextarea1" path="date">Target Date</form:label>
    <form:textarea class="form-control" id="date" rows="1" path="date"></form:textarea>
  	<form:errors path="date" cssClass="test-warning"/>
  	<br>
  	<form:label for="exampleFormControlTextarea1" path="isDone">Is Done ?</form:label>
    <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="1" path="isDone"></form:textarea>
  	<form:errors path="isDone" cssClass="test-warning"/>
  
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
</div>
<script>
	$("#date").datepicker({
		format:'dd/mm/yyyy'
	});
	
</script>
<%@ include file="footer.jsp"%>