<!DOCTYPE html>

<html lang="en">

<body>
	<c:url value="/resources/text.txt" var="url"/>
	<spring:url value="/resources/text.txt" htmlEscape="true" var="springUrl" />
	Spring URL: ${springUrl} at ${time}
	<br>
	JSTL URL: ${url}
	<br>
	Message: ${message}
	
	<h1>To do list</h1>
	<ul>
		<li>hi</li>
		<li>hi</li>
	</ul>
</body>

</html>