<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Member Details</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<%@ page import="java.util.*"%>
<%@ page import="com.ncs.model.*"%>
<!-- Navbar -->
  	<nav class="navbar navbar-expand-lg navbar-light">
	  <a class="navbar-brand" href="/ncsLibrary/memberHome.jsp"><i class="fa-solid fa-book-open"></i></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item dropdown active">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          <i class="fa-solid fa-user"></i><% out.println(session.getAttribute("memberName")); %>
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="right:0; left: auto;">
		          <a class="dropdown-item" href="/ncsLibrary/updateDetails.jsp">Update Details</a>
		          <div class="dropdown-divider"></div>
		          <a class="dropdown-item" href="/ncsLibrary/index.html">Logout</a>
		        </div>
      		</li>
	    </ul>
	  </div>
	</nav>
<!-- Body -->
<div class="mem-home-body">
	<div class="side-image"></div>

	<div class="container" style="height: 90vh;">
		<h1 class="mx-auto m-3">Update Details</h1>
		<div id="update-details">
			<form action="/ncsLibrary/UpdateDetails">
			<div class="form-group row">
			    <label for="MemberName" class="col-sm-2 col-form-label">Name:</label>
			    <div class="col-sm-10">
			      <input type="text" readonly class="form-control-plaintext" value="<%out.print(session.getAttribute("memberName"));%>">
			    </div>
			 </div>
			 <div class="form-group row">
			    <label for="MemberDob" class="col-sm-2 col-form-label">Date of Birth:</label>
			    <div class="col-sm-10">
			      <input type="text" readonly class="form-control-plaintext" value="<%out.print(session.getAttribute("memberDob"));%>">
			    </div>
			 </div>
			  <div class="form-group row">
			    <label for="memberEmail" class="col-sm-2 col-form-label">Email:</label>
			    <div class="col-sm-10">
			      <input type="text" class="form-control" value="<%out.print(session.getAttribute("memberEmail"));%>" name = "memberEmail" required>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="currentPass" class="col-sm-2 col-form-label">Current Password*:</label>
			    <div class="col-sm-10">
			      <input id="password" type="password" class="form-control" name = "memberPwd" required>
			      <i id="show" class="fa-regular fa-eye-slash" onclick="showPwd()"></i>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="memberEmail" class="col-sm-2 col-form-label">New Password:</label>
			    <div class="col-sm-10">
			      <input type="password" id="txtNewPassword" class="form-control" name = "memberNewPwd">
			      <i id="show" class="fa-regular fa-eye-slash" onclick="showPwd()"></i>
			    </div>
			  </div>
			  <div class="form-group row">
			    <label for="memberEmail" class="col-sm-2 col-form-label">Confirm Password:</label>
			    <div class="col-sm-10">
			      <input type="password" id="txtConfirmPassword" onkeyup="checkPasswordMatch()" class="form-control" name = "conPwd">
			      <i id="show" class="fa-regular fa-eye-slash" onclick="showPwd()"></i>
			      <div class="registrationFormAlert" style="color:green;" id="CheckPasswordMatch"></div>
			    </div>
			  </div>
				<button type="submit" class="btn btn-outline-dark">Update my details</button>
			</form>
		</div>
	</div>
</div>

<!-- Footer -->
  <footer class="footer">
    <div class="footer-title">
      <p>Created by Eunice, just for fun</p>
    </div>
    <div class="footer-body">
      <a href=""><i class="fa-brands fa-github"></i></a>
      <a href=""><i class="fa-brands fa-linkedin"></i></a>
    </div>
  </footer>

<script type="text/javascript" src="./javascript/login_effect.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>