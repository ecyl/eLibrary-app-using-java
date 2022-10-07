<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Remove Book Success</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="./css/style.css">
</head>
<body>
<!-- Navbar -->
	<nav class="navbar navbar-expand-lg navbar-light">
	  <a class="navbar-brand" href="/ncsLibrary/welcomeAdmin.jsp"><i class="fa-solid fa-book-open"></i></a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav ml-auto">
	      <li class="nav-item dropdown active">
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          <i class="fa-solid fa-user"></i>Admin
		        </a>
		        <div class="dropdown-menu" aria-labelledby="navbarDropdown" style="right:0; left: auto;">
		          <a class="dropdown-item" href="/ncsLibrary/index.html">Logout</a>
		        </div>
      		</li>
	    </ul>
	  </div>
	</nav>
	
<!-- Alert -->
	 <div class="alert alert-success alert-dismissible fade show" role="alert">
	  <strong>Book removed successfully!</strong>
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>
<!-- Banner -->
  <div class="admin-banner" style="height:70vh">
    <div class="container admin-banner-info">
    	<div class="row col-6 stats">
    		<h3 id="number"><% out.println(session.getAttribute("bookCount")); %></h3>
    		<h3 id="caption"><a href="/ncsLibrary/removeBook.jsp">books</a></h3>
    	</div>
    	<div class="row col-6 stats">
    		<h3 id="number"><% out.println(session.getAttribute("memCount")); %></h3>
    		<h3 id="caption"><a href="/ncsLibrary/ViewMembers">members</a></h3> 
    		
    	</div>
    </div>
  </div>
  
<!-- Body-->
  <div class="container mx-auto d-flex justify-content-center">
  	<div class="admin-body">
		<h1 class="text-center">Time to get working</h1>
		<div class="admin-options text-center">
		  	<button class="add-new-btn" data-toggle="modal" data-target="#addNewBookModal">Add new book</button> 
	  	</div>
	  	<div class="admin-options text-center">
	  		<a href="/ncsLibrary/removeBook.jsp">Remove book</a>
	  	</div>
	  	<div class="admin-options text-center">
	  	<a href="/ncsLibrary/ViewLoanBooks">View all books on loan</a>
	  	</div>
	</div>
  </div>
  
<!--  Add New Book Modal -->
	<div class="modal fade" id="addNewBookModal" tabindex="-1" role="dialog" aria-labelledby="addNewBookModalCenterTitle" aria-hidden="true">
	  <div class="modal-dialog modal-dialog-centered" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="addNewBookModalLongTitle">Add New Book</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	      	<form action="/ncsLibrary/AddBook">
			  <div class="form-group">
			    <label for="title">Book Title:</label>
			    <input type="text" class="form-control" name="bookTitle">
			  </div>
			  <div class="form-group">
			    <label for="author">Book Author:</label>
			    <input type="text" class="form-control" name="bookAuthor">
			  </div>
			  <div class="form-group">
			    <label for="genre">Genre:</label>
			    <input type="text" class="form-control" name="bookGenre">
			  </div>
			  <button type="submit" class="btn btn-outline-dark">Add Book</button>
			</form>
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
  
<script type="text/javascript" src="./javascript/login_effect.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>