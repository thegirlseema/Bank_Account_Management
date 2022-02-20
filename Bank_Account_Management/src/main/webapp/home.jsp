<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<style>
	body{
	background-color:lightgreen;
	color:darkblue;
	}
	h1{
	color:black;
	}
	</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="" style="border:orange; border-width:5px; border-style:solid;">
<h1>Welcome To Online Banking:</h1>

<!-- Your User Name Is:</p>
<strong>${userName}</strong> --><p>

<h3>${String}</h3>
<%
String cc="";
Cookie ck[]=request.getCookies();
for(Cookie c:ck) {
	if(c.getName().equals("cki"))
	{
		cc=c.getValue().toString();
	}
}
out.print(cc);
%>
</form>
</center>
<h2>Reports</h2><br><br>
<div style="float:left">
<button id="deposit">Deposit</button>
<button id="dailyT">TodaysTranscation</button>
<button id="outStanding">Outstanding Report</button>
</div>
</body>
</html>