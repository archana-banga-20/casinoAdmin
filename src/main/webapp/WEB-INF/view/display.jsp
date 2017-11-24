<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
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
      <li><a href="register"><button class="btnNav">Register</button></a></li>
      <li><a href="display"><button class="btnNav myActive">UserList</button></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
     <li class="displayHeading">Welcome To Casino Admin App!</li>
    </ul>
  </div>
</nav>


<div class="displayContainer">
<div class ="container" style=";margin-top: 7" >
	
  <form action="/search?name="+name+"?contact="+contact"?email="+email" method="get">
			  <div class="row col-lg-8">
			  	<div class="form-group col-lg-6">
				    <label class="col-lg-3" for="name">Name</label>
				    <input class="col-lg-6" type="text" class="form-control" id="name" name="name">
			  </div>
			  
				<div class="form-group col-lg-6">
				    <label class="col-lg-3" for="name">Contact</label>
				    <input class="col-lg-6" type="text" class="form-control" id="contact" name="contact">
				</div>
			</div>
			<div class="row col-lg-8">
			<br>
			  <div class="form-group col-lg-6">
			    <label class="col-lg-3" for="email">Email Id</label>
			    <input class="col-lg-6" type="text" class="form-control" id="email" name="email"><br>
			  </div>

			  <div class="form-group col-lg-6">
			  <button type="submit" class="btn btn-default" style="text-align: center;margin-left: 15%;position: relative;
			  background-color: #ED1D65;border: 0;width: 50%">Submit</button>
			</div>
			</div>
</form>			
</div>

<div style="margin-top: 10%;width: 700px">

<table>

  <tr style="background-color: #F97478">
    <th>S No</th>
    <th>Name</th>
    <th>DOB</th>
    <th>Contact</th>
    <th>Email</th>
    <th>Balance(in Rs.)</th>
    <th>Recharge</th>
  </tr>
  
<c:set var="unique_id" value="0" />
<c:set var="count" value="0" scope="page" />
  <c:forEach items="${customers}" var="item" >
  <c:set var="count" value="${count + 1}" scope="page"/>
  <tr> 
    <td>${count}</td>
    <td>${item.name}</td>
    <td>${item.dob}</td>
    <td>${item.contact}</td>
    <td>${item.email}</td>
    <td>${item.balance}</td>
    <td><a><span style="color: #ED1D65" class="glyphicon glyphicon-plus" onclick='recharge("${item.uniqueId}")' data-toggle="modal" data-target="#myModal"></span></a></td> 
  </tr>
</c:forEach> 
</table>

<!--  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal" style="background-color: #ED1D65;border: 0">Open Small Modal</button>
 -->
  <!-- Modal -->
  <div class="modal fade" id="myModal" role="dialog" style="border-color: #ED1D65">
    <div class="modal-dialog modal-md">
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Recharge Balance</h4>
        </div>
        
         <div class="modal-body">
         <form action="/recharge" method="post">
         		 <div class="row">
	          	<div class="col-md-3"></div>
	          	<div class="col-md-3">
	          	<label>Amount</label>
	          	</div>
	          	
	          	<div class="col-md-1">
	          	<label>Rs.</label>
	          	</div>
	            
	            <input type="text" name="uniqueId" id="uniqueId" style="display:none">
	            
	          	<div class="col-md-3">
	          	<input type="text" name="balance" id="balance">
	          	</div>
           </div>
           
           <div class="row">
           <div class="col-md-9"></div>
           		<div class="col-md-3">
           		    <button type="submit" class="btn btn-default" style="background-color: #ED1D65;border: 0">Recharge</button>
           		</div>
           </div>
         </form>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
<script type="text/javascript">
	function recharge(id) {
		console.log(id);
		document.getElementById('uniqueId').value  = id;
	}
</script>

</body>
</html>