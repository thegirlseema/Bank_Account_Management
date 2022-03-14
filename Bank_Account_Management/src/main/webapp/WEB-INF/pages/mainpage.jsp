<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <title>Banking Management System</title>

        <style>
        .content {
            max-width: 1000px;
            margin: auto;
          }
          body {
            background-color: rgb(177, 253, 200);
          }
              
          

.button {
    background-color: #4CAF50; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin: 4px 2px;
    cursor: pointer;
  }

</style>
    </head>
    <body>

          <body>
          

            
            <center>
            
        <div style="border:10px double green;padding:2%;height:90%;">
          <div class="content">
         
        <h1>Welcome!!</h1>
		<br>
        <form action="detail" method="post" >
        	<input type="submit" class="button" name="detail" value="Account Detail">
        </form>
        <br>
        <br>
        <br>
        <a href="transaction.html">
            <button class="button">Money Transfer</button>
           </a>
           

           <br>
           <br>
           <br>

           <br>
        <a href="clientreport">
            <button class="button">Transaction History</button>
           </a>
           <br>
           <br>
           <br>
        	
        	<a href="Logout">
            <button class="button" onclick="alert('Successflly logged Out);">Logout</button>
           </a>
           <!-- onclick="alert('Successfully logged Out);" -->
            </div>
        </div>
    </center>
    </body>
</html>