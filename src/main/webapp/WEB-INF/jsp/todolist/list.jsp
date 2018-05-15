<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
	<style>
		.stroked { text-decoration: line-through; }
	</style>
	
	<%@ include file="scripts/head-css.jsp" %>
</head>

<body>
	<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
      <a class="navbar-brand" href="">Todolist</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarCollapse">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item active">
            <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
          </li>
        </ul>
      </div>
    </nav>
	
	<main role="main" class="container">
		<h1>To do list</h1>
		<ul>
			<c:forEach items="${taskList}" var="task">
	           <li class="<c:if test="${task.done}">stroked</c:if>" id="${task.id}">
	           		<input type="checkbox" class="done" <c:if test="${task.done}">checked</c:if>>
	           		<span class="task-name">${task.name}</span> 
	           		<span class="edit glyphicon glyphicon-pencil">Edit</span> 
	           		<span class="delete glyphicon glyphicon-remove">Delete</span>
	           		<!-- <ul class="task-description">
	           			<li>${task.description}</li>
	           		</ul> -->
	           </li>
	           
		    </c:forEach>
		</ul>
		<button type="button" class="btn btn-primary" id="add-task">Add task</button>
	</main>
	
	<%@ include file="scripts/bottom-scripts.jsp" %>
	<script type="text/javascript">
		$("li > .delete").click(function() {
			var $task = $(this).parent();
			
			$.ajax({
				url: "delete",
				type: "get",
				contentType: "application/json",
				data: {
					id: $task.attr('id'),
				},
				success: function() {
					$task.fadeOut();
				},
				error: function(e) {
					console.log(e.responseText);
				}
			});
		});
		
		$(".done").click(function() {
			$task = $(this).parent();
			
			$.ajax({
				url: "done",
				type: "get",
				contentType: "application/json",
				data: {
					id: $task.attr('id'),
					done: !$task.hasClass("stroked"),
				},
				success: function() {
					$task.toggleClass('stroked');
				},
				error: function(e) {
					console.log(e.responseText);
				}
			});
		});
		
		$( ".edit" ).click(function() {
			window.location.href = "edit?id=" + $(this).parent().attr('id');
		});
		
		$(".task-name").click(function() {
			
		});
		
		$("button#add-task").click(function () {
			window.location.href = "task";
		});
	</script>
	
	
</body>

</html>