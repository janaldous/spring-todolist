<%@ include file="../scripts/top.jsp" %>

<main role="main" class="container">
	<h1>Edit Task</h1>
    <form:form action = "editTask" modelAttribute="task" method = "post">
   		<form:hidden path="id"/>
   		<form:hidden path="done"/>
   		<form:errors path="name"/><br>
	    <form:label path="name" required="true">Name:</form:label> 
	    <form:input path="name"/>
	    <br>
	    <form:label path="description">Description:</form:label> 
	    <form:input path= "description" />
	    <br>
	    <input type = "submit" value = "Submit" />
    </form:form>
</main>

<%@ include file="../scripts/bottom.jsp" %>