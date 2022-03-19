<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
h1 {
	color: #0ae312;
}

table, th, td {
	width: 40%;
	background-color:rgb(177, 253, 200);
	border: 1px solid black;
}
body{
	background-color:yellow;
	background-image:url("https://5.imimg.com/data5/EK/HD/MY-25455024/banking-management-system-250x250.jpg");
	background-size:cover;
}
</style>
</head>
<body>
	<div align="center">
		<div style="background-color: #4CAF50; height: 45px; width: 50%; align-items: center; color: white; "><h1>Last Transaction Details</h1></div>
		<%@ page import="com.bank.client.Client"%>

		<table border="1">
			<tr>
				<th>Current Balance</th>
			<tr>
			<tr>
				<td>${client.getAccountbalance()}</td>
			</tr>
			<tr>
				<th>Out Standing Balance</th>
			<tr>
			<tr>
				<td>${client.getOutstandingbalance()}</td>
			</tr>						
		</table>
		<form action="home" method="get">
		<button type="submit">Back to Home</button>
		</form>
		
	</div>
</body>
</html>