<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
   	<link rel="stylesheet" href="css/bootstrap-social.css">
		<!-- jQuery library -->
		<link rel="stylesheet" type="text/css" href="./css/styles.css">
<title>REGISTER</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="container">
       <div class="row row-content align-items-center">
		<div class="col-12 offset-sm-2 col-sm-8">
			<div class="card">
		              <h3 class="card-header text-white text-center">REGISTER</h3>
		              <div class="card-body">
		                <form action="/RestClient9/StudentServlet" method="POST">
		                   <div class="col-md-10">
		                    <div class="form-group row">
		                    	
		                         <input type="text"  name="name" required="required">
		                         <label>Name</label>
		                         			                        
		                    
		                    </div>
		                    <div class="form-group row">
		                            <input type="text"  name="city" required="required">
			                        <label>City</label>	                        
		                    </div>
		                   
		                    <div class="form-group row">
		                        <input type="email" name="email" required="required">
		                        <label for="email">Email</label>
		                        
		                    </div>
		                    <div class="row">
		                        <div class="col-5 col-md-3">
				                    <div class="form-group ">
			                            <input type="number"  name="age" required>
				                        <label for="age" class="col-12 col-sm-auto">Age</label>
				                    </div>
		                        </div>
		                        <div class="col-5 col-md-3">
		                        	<div class="form-group">
			                            <input type="number" name="marks" required>
				                        <label for="marks">Marks</label>
		                        	</div>
		                        </div>
		                        <div class="col-md-6 col-lg-4 offset-lg-1">
			                        <label for="sex" class="col-form-label">Sex</label>
	                                <div class="form-check-inline">
	                                    <input class="form-check-input" type="radio" name="sex" id="male" value="male">
	                                    <label class="form-check-label" for="male">M</label>
	                                </div>
	                                <div class="form-check-inline">
	                                    <input class="form-check-input" type="radio" name="sex" id="female" value="female">
	                                    <label class="form-check-label" for="female">F</label>
	                          		</div>
		                         </div>
		                    </div>
		                    </div>
		                    <div class="form-group row">
		                        <div class="offset-md-2 col-md-10">
		                            <button type="submit">
								      <span></span>
								      <span></span>
								      <span></span>
								      <span></span>
								      Submit
								    </button>
		                        </div>
		                    </div>
		                </form>
		            </div>
	            </div>
	            </div>
       </div>
	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>