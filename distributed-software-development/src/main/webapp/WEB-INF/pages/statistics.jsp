<%@taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Distributed Software Development</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<style>
  body {
    padding-top: 50px;
  }
 </style>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
</head>
<body id="body">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			 <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#body">DSD TeamTitans</a>
            </div>
            <div class="collapse navbar-collapse" id="">
            	<ul class="nav navbar-nav">
					<li>
						<a class="page-scroll" href="#userstats">User Statistics</a>
					</li>
					<li>
						<a class="page-scroll" href="#filestats">File Statistics</a>
					</li>
					<li>
						<a class="page-scroll" href="#buildstats">Code Statistics</a>
					</li>											
				</ul>
				<ul class="nav navbar-nav navbar-right">					
					<c:url value="/logout" var="logoutUrl" />
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a class="page-scroll" href="#body" >Welcome : ${pageContext.request.userPrincipal.name}</a></li>
					</c:if>
					<li> <a href="javascript:formSubmit()"> Logout</a></li>											
				</ul>
            </div>			
		</div>
	</nav>
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
	</form>
	<section  id="userstats" style ='background-color: #FFFFFF'>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-6 text-center">
                    <h3 class="section-heading text-center">User Statistics</h3>
                    <hr class="light">                    
                    <table class="table table-hover" id="usertable">
				    	<thead>
					      <tr>
					        <th>User Name</th>
					        <th>Number of Commits</th>
					        <th>Online Time</th>
					        <th>Start Date</th>
					      </tr>
					    </thead>					    
					    <tbody>
					    	<tr>
						        <td>Kiran</td>
						        <td>23</td>
						        <td>32.0 Hrs</td>
						        <td>22-Sep-2015</td>					        
					      	</tr>
					      	<tr>
						        <td>Supraj</td>
						        <td>20</td>
						        <td>32.0 hrs</td>
						        <td>22-Sep-2015</td>				        
					      	</tr>
					      	<tr>
						        <td>Rathnakar</td>
						        <td>18</td>
						        <td>30.04 Hrs</td>
						        <td>23-Sep-2015</td>				        
					      	</tr>
					      	<tr>
						        <td>Yoga</td>
						        <td>18</td>
						        <td>30.0 Hrs</td>
						        <td>23-Sep-2015</td>				        
					      	</tr>
					      	<tr>
						        <td>Nithya</td>
						        <td>18</td>
						        <td>30.0 Hrs</td>
						        <td>23-Sep-2015</td>				        
					      	</tr>
					    </tbody>					      
				  	</table>
				</div>
            </div>
        </div>
    </section>
    
    <section  id="filestats" style ='background-color: #EFFBFB'>
        <div class="container">
            <div class="row">
            	<div class="col-lg-12 col-md-6 text-center"> 
            		<h3 class="section-heading text-center">File statistics</h3>
            	</div>
                <div class="col-lg-8 col-lg-offset-2">                    
                    <hr class="light">  
                    <table class="table table-hover" id="files">
                    	 <tbody>
                    	 	<tr>
                    	 		<td>Total Number of commits</td>
                    	 		<td>10</td>
                    	 	</tr>
                    	 	<tr>
                    	 		<td>Last Committed by</td>
                    	 		<td>test_user</td>
                    	 	</tr>
                    	 	<tr>
                    	 		<td>Lines of Code changed since last commit</td>
                    	 		<td>1234</td>
                    	 	</tr>
					    </tbody>
                    </table>
                 </div> 
	                  <div class="col-lg-12 col-md-6 text-center">           
	                   <table class="table table-hover" id="filesperuser">
				    	<thead>
					      <tr>
					        <th>User Name</th>
					        <th>Online Time</th>
					        <th>Duration of work</th>
					        <th>Commits made</th>
					      </tr>
					    </thead>					    
					    <tbody>
					    	<tr>
						        <td>Rathnakar</td>
						        <td>10 hrs</td>
						        <td>25 hrs</td>
						        <td>9</td>				        
					      	</tr>
					      	<tr>
						        <td>Yoga</td>
						        <td>8 hrs</td>
						        <td>18 hrs</td>
						        <td>8</td>				        
					      	</tr>
					      	<tr>
						        <td>Nithya</td>
						        <td>9 hrs</td>
						        <td>19 hrs</td>
						        <td>7</td>					        
					      	</tr>
					      	<tr>
						        <td>Supraj</td>
						        <td>10 hrs</td>
						        <td>20 hrs</td>
						        <td>9</td>				        
					      	</tr>
					    </tbody>					      
				  	</table>
			  	</div>
			</div>
        </div>
    </section>
    
    <section  id="buildstats" style ='background-color: #FFFFFF;'>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-6 text-center">
                    <h3 class="section-heading text-center">Code Statistics</h3>
                    <hr class="light">                    
                    <table class="table table-hover" id="buildtable">
				    	<thead>
					      <tr>
					        <th>Build Number</th>
					        <th>Triggered By</th>
					        <th>Lines of Code changed</th>
					        <th>Build Errors</th>
					        <th>Compilation Errors</th>					        
					      </tr>
					    </thead>					    
					    <tbody>
					    	<tr>
						        <td>build1</td>
						        <td>Nithya</td>
						        <td>323</td>
						        <td>1</td>
						        <td>1</td>					        
					      	</tr>
					      	<tr>
						        <td>build2</td>
						        <td>Supraj</td>
						        <td>534</td>
						        <td>0</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build3</td>
						        <td>Kiran</td>
						        <td>320</td>
						        <td>0</td>
						        <td>0</td>					        
					      	</tr>
					    </tbody>					      
				  	</table>
				</div>
            </div>
        </div>
    </section>	
</body>
</html>
<html>