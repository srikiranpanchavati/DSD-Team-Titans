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
		var name = $('input[name=projectName]').val();
		var bname = $('input[name=branchName]').val();
		var url = $('input[name=giturl]').val();
		var projectData = $(this).closest('form');
        var project= projectData.serializeObject();
		$.ajax({
            'type': 'POST',
                'url':"profile",
                'contentType': 'application/json',
                'data': JSON.stringify(project),
                'dataType': 'json',
                success: function(data) {

                if (data == 'SUCCESS')
                {
                	var tr = "<tr><td>"+name+"</td><td>"+url+"</td><td><a class=\"page-scroll\" href=\"#userstats\" id=\""+url+"\">View Statistics</a></td><td>"+bname+"</td></tr>";
            		$('#urltable > tbody:last').append(tr);
                }
                else
                    {
                    alert(data);
                    }

                }
            });
		var name = $('input[name=projectname]').val("");
		var bname = $('input[name=branchname]').val("");
		var url = $('input[name=giturl]').val("");
	});
	
	$.fn.serializeObject = function() {
	    var o = {};
	    var a = this.serializeArray();
	    $.each(a, function() {
	        if (o[this.name]) {
	            if (!o[this.name].push) {
	                o[this.name] = [o[this.name]];
	            }
	            o[this.name].push(this.value || '');
	        } else {
	            o[this.name] = this.value || '';
	        }
	    });
	    return o;
	};
});
</script>
<script>
	function formSubmit() {
		document.getElementById("logoutForm").submit();
	}
</script>
</head>
<body id="top">
	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			 <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#top">DSD TeamTitans</a>
            </div>
            
			<div class="collapse navbar-collapse" id="">				
				<ul class="nav navbar-nav navbar-right">					
					<c:url value="/logout" var="logoutUrl" />
					<c:if test="${pageContext.request.userPrincipal.name != null}">
						<li><a class="page-scroll" href="#top" >Welcome : ${pageContext.request.userPrincipal.name}</a></li>
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
					    <c:forEach var="details" items="${projectDetails}">
					    	<tr>
					    		<td>${details.projectName}</td>
					    		<td>${details.projectURL}</td>
					    		<td>${details.branch}</td>
					    		<td><a class="page-scroll" href="#userstats" id="${details.projectURL}">View Statistics</a></td>
					    	</tr>
					    </c:forEach>
					    </tbody>					      
				  	</table>
				  	<hr class="light">
				  	<h4>Add a new project here:</h4>
                    <form class="form-inline" method = "post" action="<c:url value='/profile' />" id = "projectUpdate">
  						<div class="form-group">
  							<input type="hidden" class="form-control" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
  							<label for="proname">Project Name: </label>
  							<input type="hidden" class="form-control" name="userName" value="${pageContext.request.userPrincipal.name}">
  							<input type="text" class="form-control" name="projectName" placeholder="Sample Project">  							
  							<label for="proname">Branch Name: </label>
  							<input type="text" class="form-control" name="branch" placeholder="master">
						    <label for="githuburl">Git hub URL: </label>
						    <input type="url" class="form-control" name="projectURL" placeholder="http://github.com/dummy">
						    <button type="submit" class="btn btn-default" name="update" id="submit1">add</button>
						</div>
					</form>
                </div>
            </div>
        </div>
    </section>    
</body>
</html>
<html>