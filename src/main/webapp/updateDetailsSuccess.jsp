<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Update Details Sucess</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
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
	<!-- Alert -->
	<div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Your details have been successfully updated!</strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
<!-- Body -->
  <div class="mem-home-body">
	  <div class="side-image">
	  	<h1 class="welcome-mem">Welcome back, <br> 
	  	<% out.println(session.getAttribute("memberName")); %></h1>
	  </div>	
	  <div class="container">
		<div class="mem-stats">
			<h3>Member ID: <% out.println(session.getAttribute("memberId")); %></h3>
			<h3>You currently have: <% out.println(session.getAttribute("bookCount")); %> /5 books on loan</h3>
		</div>
		
		
		<div class="mem-options">
			<h2 class="options-header">What would you like to do today?</h2>
			<div class="options-body">
				<div class="card" style="width: 18rem; height: min-content;">
				  <div class="card-body">
				    <h5 class="card-title">The Library</h5>
				    <p class="card-text">Check out all the books we have in our library</p>
				    <a href="/ncsLibrary/ViewAllBooks" class="card-link"><i class="fa-solid fa-book"></i></a>
				  </div>
				</div>
				
				<div class="card" style="width: 18rem; height: min-content;">
				  <div class="card-body">
				    <h5 class="card-title">My Loan Books</h5>
				    <p class="card-text">Look at all the books that you have loaned so far</p>
				    <a href="/ncsLibrary/ViewMyLoanBooks" class="card-link"><i class="fa-solid fa-book-bookmark"></i></a>
				  </div>
				</div>
				
				<div class="card" style="width: 18rem; height: min-content;">
				  <div class="card-body">
				    <h5 class="card-title">My Favourites</h5>
				    <p class="card-text">Check out the books that you love</p>
				    <a href="/ncsLibrary/ViewAllFav" class="card-link"><i class="fa-solid fa-heart"></i></a>
				  </div>
				</div>
			</div>
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
  
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>