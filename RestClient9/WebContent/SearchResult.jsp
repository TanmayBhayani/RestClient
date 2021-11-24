<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.tanmay.Student" %>  
	<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
   	<link rel="stylesheet" href="css/bootstrap-social.css">
		<!-- jQuery library -->
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
		<link rel="stylesheet" type="text/css" href="./css/styles2.css">
		<link rel="stylesheet" type="text/css" href="./css/table.css">
<title>Search Result</title>
</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<div class="container">
	<div class="row row-content align-items-center justify-content-center">
		<div class="col-lg-6 col-md-8 col-sm-10">
				<%
				ArrayList<Student> students = (ArrayList<Student>)request.getAttribute("students");
					if(students.isEmpty()){%>
					<b>NO DATA FOUND</b>
					<%}else{ %>
					<table>
					<tr>
						<th><b>ID</b></th>
						<th><b>Name</b></th>
						<th><b>City</b></th>
						<th><b>Email</b></th>
						<th><b>Sex</b></th>
						<th><b>Age</b></th>
						<th><b>Marks</b></th>
					</tr>
					<%
					for(Student student:students){%> 
						<tr>
			                <td><%=student.getId()%></td>
			                <td><%=student.getName()%></td>
			                <td><%=student.getCity()%></td>
			                <td><%=student.getEmail()%></td>
			                <td><%=student.getSex()%></td>
			                <td><%=student.getAge()%></td>
			                <td><%=student.getMarks()%></td>
						</tr>
					<%}%>
						
					<% }%>
					</table>
				 <button onclick="window.location.href = '/RestClient9/index.jsp';"> 
		        Go back
		    </button>
			</div>
	  </div>
</div>
    <jsp:include page="footer.jsp"></jsp:include>
</body>
</html>