<%@ include file="../scripts/top.jsp" %>

<main role="main" class="container">
<h1>New Task</h1>
   <form action = "task" method = "POST">
    Name: <input type = "text" name = "name" value="${task.name}">
	<br>
	Description: <input type = "text" name = "description" value="${task.description}"/>
   <input type = "submit" value = "Submit" />
</form>
</main>

<%@ include file="../scripts/bottom.jsp" %>