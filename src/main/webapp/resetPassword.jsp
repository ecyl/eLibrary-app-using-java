<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Reset Password</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<!-- Navbar -->
  <nav class="navbar navbar-expand-lg navbar-light">
	  <a class="navbar-brand" href="/ncsLibrary/index.html"><i class="fa-solid fa-book-open"></i></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	</nav>

<!-- Alert -->
<div class="alert alert-primary" role="alert">
  Your details have been verified. Please key in this OTP: <strong><%= session.getAttribute("OTP")%></strong> to reset your password.
</div>
		
<!-- Body -->
	<div class="mem-login-con-body">
		<div class="side-image"></div>	
		<div class="mem-login-form">
			<h1>Reset Password</h1>
			
			<form action="/ncsLibrary/ResetPassword">
			  <div class="form-group">
			    <label for="memberName">OTP:</label>
			    <input type="text" class="form-control" name="Otp" required>
			  </div>
			   <div class="form-group">
			    <label for="MemPassword">New Password:</label>
			    <input type="password" id="txtNewPassword" class="form-control" name = "memberPwd" required>
			    <i id="show" class="fa-regular fa-eye-slash" onclick="showPwd()"></i>
			  </div>
			  <div class="form-group">
			    <label for="ConPassword">Confirm Password:</label>
			    <input type="password" id="txtConfirmPassword" onkeyup="checkPasswordMatch()"class="form-control" name = "conPwd" required>
			    <i id="show" class="fa-regular fa-eye-slash" onclick="showPwd()"></i>
			    <div class="registrationFormAlert" style="color:green;" id="CheckPasswordMatch"></div>
			  </div>
			  <button type="submit" class="btn btn-outline-dark">Submit</button>
			</form>
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
<!--  jQuery -->
<script type="text/javascript">
function showPwd() {
	  var y = document.getElementById("txtNewPassword");
	  var z = document.getElementById("txtConfirmPassword");
	  if (y.type === "password" || z.type === "password") {
	    y.type = "text";
	    z.type = "text";
	  } else {
	    y.type = "password";
	    z.type = "password";
	  }
	}
</script>
<script type="text/javascript" src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>