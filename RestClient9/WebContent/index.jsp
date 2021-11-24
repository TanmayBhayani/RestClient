<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
   	<link rel="stylesheet" href="css/bootstrap-social.css">
		<!-- jQuery library -->
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
		<link rel="stylesheet" type="text/css" href="./css/styles2.css">
<title>SEARCH</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	Search!!!
	<div class="container">
		<div class="row row-content">
			<form action="/RestClient9/StudentServlet" method="GET">
				<label><input type="text" name="name" placeholder="Name"></label><br>
				<button type="submit">SUBMIT</button>
			</form>
		</div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>