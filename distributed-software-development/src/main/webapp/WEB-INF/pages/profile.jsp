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
$(document).ready(function(){
	$('#submit').click(function () {
		var name = $('input[name=projectname]').val();
		var bname = $('input[name=branchname]').val();
		var url = $('input[name=giturl]').val();
		var tr = "<tr><td>"+name+"</td><td>"+url+"</td><td><a class=\"page-scroll\" href=\"#userstats\" id=\""+url+"\">View Statistics</a></td><td>"+bname+"</td></tr>";
		$('#urltable > tbody:last').append(tr);
		var name = $('input[name=projectname]').val("");
		var bname = $('input[name=branchname]').val("");
		var url = $('input[name=giturl]').val("");
	});
});
</script>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
</head>
<body id="bodystart">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			 <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#bodystart">DSD TeamTitans</a>
            </div>
            
			<div class="collapse navbar-collapse" id="">
				<ul class="nav navbar-nav">
					<li>
						<a class="page-scroll" href="#bodystart">My Projects</a>
					</li>
					<li>
						<a class="page-scroll" href="#userstats">User statistics</a>
					</li>
					<li>
						<a class="page-scroll" href="#filestats">File statistics</a>
					</li>
					<li>
						<a class="page-scroll" href="#buildstats">Code statistics</a>
					</li>											
				</ul>
				<ul class="nav navbar-nav navbar-right">					
					<c:url value="/logout" var="logoutUrl" />
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a class="page-scroll" href="#bodystart" >Welcome : ${pageContext.request.userPrincipal.name}</a></li>
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
	
	<section  id="links" style ='background-color: #EFFBFB'>
        <div class="container">
            <div class="row">
                <div class="col-lg-12 col-md-6 text-center">
                    <h3 class="section-heading text-center">My Github Projects</h3>
                    <hr class="light">                    
                    <table class="table table-hover" id="urltable">
				    	<thead>
					      <tr>
					        <th>Project Name</th>
					        <th>Git Hub URL</th>
							<th>branch Name</th>
					        <th>Statistics</th>
					      </tr>
					    </thead>					    
					    <tbody>
					    </tbody>					      
				  	</table>
				  	<hr class="light">
				  	<h4>Add a new project here:</h4>
                    <form class="form-inline">
  						<div class="form-group">
  							<label for="proname">Project Name: </label>
  							<input type="text" class="form-control" name="projectname" placeholder="Sample Project">  							
  							<label for="proname">Branch Name: </label>
  							<input type="text" class="form-control" name="branchname" placeholder="master">
						    <label for="githuburl">Git hub URL: </label>
						    <input type="url" class="form-control" name="giturl" placeholder="http://github.com/dummy">
						    <button type="button" class="btn btn-default" id="submit">add</button>
						</div>
					</form>
                </div>
            </div>
        </div>
    </section>	
    
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
						        <td>build1</td>
						        <td>user1</td>
						        <td>1234</td>
						        <td>2</td>					        
					      	</tr>
					      	<tr>
						        <td>build2</td>
						        <td>user2</td>
						        <td>1235</td>
						        <td>2</td>				        
					      	</tr>
					      	<tr>
						        <td>build3</td>
						        <td>user3</td>
						        <td>1212</td>
						        <td>4</td>				        
					      	</tr>
					      	<tr>
						        <td>build4</td>
						        <td>user4</td>
						        <td>1211</td>
						        <td>5</td>				        
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
					        <th>Task Associated</th>
					      </tr>
					    </thead>					    
					    <tbody>
					    	<tr>
						        <td>build1</td>
						        <td>user1</td>
						        <td>1234</td>
						        <td>2</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build2</td>
						        <td>user2</td>
						        <td>1235</td>
						        <td>2</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build3</td>
						        <td>user3</td>
						        <td>1212</td>
						        <td>4</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build4</td>
						        <td>user4</td>
						        <td>1211</td>
						        <td>5</td>
						        <td>0</td>					        
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
                    <h3 class="section-heading text-center">Build Statistics</h3>
                    <hr class="light">                    
                    <table class="table table-hover" id="buildtable">
				    	<thead>
					      <tr>
					        <th>Build Name</th>
					        <th>Triggered By</th>
					        <th>Lines of Code changed</th>
					        <th>Build Errors</th>
					        <th>Compilation Errors</th>					        
					      </tr>
					    </thead>					    
					    <tbody>
					    	<tr>
						        <td>build1</td>
						        <td>user1</td>
						        <td>1234</td>
						        <td>2</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build2</td>
						        <td>user2</td>
						        <td>1235</td>
						        <td>2</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build3</td>
						        <td>user3</td>
						        <td>1212</td>
						        <td>4</td>
						        <td>0</td>					        
					      	</tr>
					      	<tr>
						        <td>build4</td>
						        <td>user4</td>
						        <td>1211</td>
						        <td>5</td>
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