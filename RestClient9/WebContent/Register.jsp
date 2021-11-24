<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	Register!!!
	<form action="/RestClient9/RestClientServlet" method="POST">
	Name:<input type="text" name="name"><br>
	Mobile no:<input type="number" name="mob_num">
	<input type="submit" value="submit">
	</form>
	<a href="index.jsp">Search</a>
</body>
</html>