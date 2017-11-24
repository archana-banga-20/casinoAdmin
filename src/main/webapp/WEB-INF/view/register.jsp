<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Casino</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
 <link rel="stylesheet" href="resources/style.css">
</head>
<body>

<nav class="navbar navbar-inverse myNavBar">
  <div>
    <ul class="nav navbar-nav">
     <li><a href="index"><button class=" btnNav">Home</button></a></li>
      <li><a href="register"><button class="btnNav myActive">Register</button></a></li>
      <li><a href="display"><button class="btnNav" href="display">UserList</button></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="displayHeading">Welcome To Casino Admin App!</li>
    </ul>
  </div>
</nav>

<div class="formParent">
<div class ="container" style=";margin-top: 7" >
	
	<form action="/register" method="post" enctype="multipart/form-data">
  
			  <div class="row">
			  	<div class="form-group col-lg-6 col-sm-6 col-md-6">
			    <label class="col-lg-3" for="name">Name</label>
			    <input class="col-lg-6" type="text"  class="form-control" name="name" id="name" pattern="^[a-zA-Z]+$" title="Name must have alphabets only" required>
			    <label id="errorName"></label>
			  </div>
			  </div>
			 
			 <div class="row">
				<div class="form-group col-lg-6 col-sm-6 col-md-6"><br>
				    <label class="col-lg-3" for="dob">DOB</label>
				    <input class="col-lg-6" type="date" class="form-control" name="dob" id="dob" max = "1999-01-01" required>
				</div>
			</div>
			 
			 <div class="row">
				<div class="form-group col-lg-6 col-sm-6 col-md-6"><br>
				    <label class="col-lg-3" for="contact">Contact</label>
				    <input class="col-lg-6" type="text" class="form-control" name="contact" id="contact" pattern="[789][0-9]{9}" title="Please enter valid contact no" required>
				</div>
			</div>
			<div class="row">
			<br>
			  <div class="form-group col-lg-6 col-sm-6 col-md-6">
			    <label class="col-lg-3" for="email">Email Id</label>
			    <input class="col-lg-6" type="email" class="form-control" name="email" id="email" title="Please enter valid email address" required><br>
			  </div>
			</div>
			<div class="row">
				<br>
			 <div class="form-group col-lg-6 col-sm-6 col-md-6">
			 	<label class="col-lg-3" for="identity_proof">Identity Proof</label>
			    <div class="upload-btn-wrapper col-lg-6" style="border: 0">
				  <button class="btn" id="identity_proof">Upload a file</button>
				  <input type="file" name="file" required />
				</div>
			  </div>
			</div>

			<div class="row" >
			  <br>
			  <a href="display"><button type="submit" class="btn btn-default" style="text-align: center;margin-left: 15%;position: relative;
			  background-color: #ED1D65;border: 0">Register</button></a>
			</div>
			</form>
			</div>
	</div>		

</body>
</html>