<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=Edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Registration page">
	<meta name="author" content="Team-Titans">
    <title>Registration Page</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.is"></script>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet" />
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<link href="css/register.css" rel="stylesheet" />
</head>
<body style='background-color: #FFBB90'>
	<!-- Registration Container -->
    <div class="container">
		<div class = "row-fluid" >			
			<form class = "form-horizontal">				
				<label for="First Name" class="control-label"> Name: </label>
				<br/>
				<div class = "row">
					<div class="col-md-4">
						<input type="text" class="form-control" id="First Name" placeholder="Enter First name" />
						<br/>
					</div>	
					<div class="col-md-4">
						<input type="text" class="form-control" id="Last Name" placeholder="Enter Last name" />
					</div>					
				</div>
								
				<label for= "Email-Id" class="control-label">Email-Id:</label>
				<br/>
                <div class="row padding-top-10">
                    <div class="col-md-8 padding-top-10">
                        <input type="text" class="form-control"	id="Email-Id" placeholder="Enter a valid Email address" />
						<br/>
                    </div>
                </div>
                
				<label for= "Password" class="control-label">Password:</label>
				<br/>
                <div class="row">
                    <div class="col-md-8">
                        <input type="password" class="form-control"	id="Password" placeholder="Enter your password" />
						<br/>
                    </div>
                </div>
                
				<label for= "Confirm Password" class="control-label">Confirm Password:</label>
				<br/>
                <div class="row">
                    <div class="col-md-8">
                        <input type="password" class="form-control"	id="Confirm Password" placeholder="Confirm password" />
                    </div>
                </div>
				<div class="row padding-top-10">
				<br/>
					<div class="col-md-2 padding-top-10">
						<button type="button" class="btn btn-success">REGISTER</button>
					</div>	
				</div>
			</form>	
		</div>
	</div>
</body>
</html>