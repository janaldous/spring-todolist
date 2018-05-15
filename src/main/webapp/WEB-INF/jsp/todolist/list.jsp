<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">

<head>
	<style>
		.stroked { text-decoration: line-through; }
	</style>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
</head>

<body>

<%@ include file="../todolist/navbar.jsp" %>
	
	<main role="main" class="container">
		<h1>To do list</h1>
		<ul>
			<c:forEach items="${taskList}" var="task">
	           <li class="<c:if test="${task.done}">stroked</c:if>" id="${task.id}">
	           		<input type="checkbox" class="done" <c:if test="${task.done}">checked</c:if>>
	           		<span class="task-name">${task.name}</span> 
	           		<span class="edit"><span class="glyphicon glyphicon-pencil"></span></span></span> 
	           		<span class="delete"><span class="glyphicon glyphicon-remove"></span></span>
	           		<!-- <ul class="task-description">
	           			<li>${task.description}</li>
	           		</ul> -->
	           </li>
	           
		    </c:forEach>
		</ul>
		<button type="button" class="btn btn-primary" id="add-task">Add task</button>
	</main>
	
	<script src="js/list.js"></script>
	
<%@ include file="../scripts/bottom.jsp" %>