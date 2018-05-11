<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">

<head>
	<style>
		.stroked { text-decoration: line-through; }
		.task-description { }
	</style>
	
	<%@ include file="scripts/head-css.jsp" %>
</head>

<body>
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
	<button type="button" class="btn btn-primary" href="task">Add task</button>
	
	
	<%@ include file="scripts/bottom-scripts.jsp" %>
	<script type="text/javascript">
		$("li > .delete").click(function() {
			var $elem = $(this).parent();
			$elem.fadeOut();
			//delete in java
			$.ajax({
				url: "delete",
				type: "get",
				contentType: "application/json",
				data: {
					id: $elem.attr('id'),
				},
				success: function() {
					console.log("j");
				},
				error: function(e) {
					console.log(e.responseText);
					$(this).parent().show();
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
	</script>
	
	
</body>

</html>