<!DOCTYPE HTML>
<html>
<head>
    <title>Getting Started: Handling Form Submission</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
	<h1>New Task</h1>
    <form action = "/task" method = "POST">
    Name: <input type = "text" name = "name" value="${task.name}">
    <br>
    Description: <input type = "text" name = "description" value="${task.description}"/>
    <input type = "submit" value = "Submit" />
 </form>
</body>
</html>