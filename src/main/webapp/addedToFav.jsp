<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>My Favourite Books</title>
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

<!-- Alert -->
	<div class="alert alert-warning alert-dismissible fade show" role="alert">
	  <strong>Oh look!</strong> You might have forgotten that you've already favourited this
	  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
	    <span aria-hidden="true">&times;</span>
	  </button>
	</div>

<!-- Body -->
<div class="return-page-body d-flex">
	<div class="side-image"></div>
	<div class="container">
		<h1 class="m-3 text-center">My Favourites:</h1>
		<div id="bookList" class="row justify-content-around mt-3">
		<% ArrayList<Book> myFavBooks = (ArrayList<Book>)session.getAttribute("myFavBooks");
					for(Book b : myFavBooks) { %>
			<div class="flip-card book">
	  <div class="flip-card-inner">
	    <div class="flip-card-front">
	    	
				<%out.print("<img src='./images/book_id_" + b.getBookId()+".jpg' class='card-img-top mx-auto mt-2' alt='book poster'</img>"); %>
	      <%out.print("<h4 id='title' class='card-title mt-3'>" + b.getTitle() +"</h4>");%>
			  	<%out.print("<p class='card-text'>Book ID: " + b.getBookId() +"</p>");%>
			    <%out.print("<p class='card-text'>by: " + b.getAuthor() +"</p>");%>
			    <%out.print("<p class='card-text'>Genre: " + b.getGenre() +"</p>");%>
	    </div>
	    <div class="flip-card-back">
	    <%out.print("<form action='/ncsLibrary/RemoveFav'> <input class='hidden d-none' type='text' name='bookId' value='"+b.getBookId()+"'> <button type='submit' class='fav-btn'> <i class='fa-solid fa-heart'></i> </button></form>"); %>
	      <h5>Book Summary</h5>
					<%out.print("<p class='card-text text-justify p-3'>" + b.getDescription() +"</p>");%>
	    </div>
	  </div>
	</div>
			<%} %>
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
  
<script type="text/javascript" src="./javascript/library.js"></script>  	
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</body>
</html>