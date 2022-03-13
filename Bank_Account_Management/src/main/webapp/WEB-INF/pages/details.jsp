<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
  <title>Bank</title>
  <meta charset="ISO-8859-1">

</head>
<body>
<div class="topnav" id="myTopnav">
 
  </a>
</div>
<br><br>
  <center>
    <div style="background-color: #4CAF50; height: 45px; width: 100%; align-items: center; color: white; "><h1>Account Details</h1></div>
  <br><br>
  <table>
  	<tr>
  		<td>Account Number</td>
  		<td>${client.getClientaccount()}</td>
  	</tr>
  	<tr>
  		<td>Client Name</td>
  		<td>${client.getClientname()}</td>
  	</tr>
  	<tr>
  		<td>User Name</td>
  		<td>${client.getUsername()}</td>
  	</tr>
  	<tr>
  		<td>Current Balance</td>
  		<td>${client.getAccountbalance()}</td>
  	</tr>
  	<tr>
  		<td>Date of Joining</td>
  		<td>${client.getDoj()}</td>
  	</tr>
  </table>
  <a href="home">
            <button class="button">Home</button>
  </a>
  </center>
</body>
</html>