<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>


<html>
<head>
  <title>Bank</title>
  <meta charset="ISO-8859-1">

</head>
<body>
<div class="topnav" id="myTopnav">
  
  
  
  <form action="register" method="get">
  <button type="submit" style="float: right">Admin Register</button>
  </form>
   
</div>
<br><br>
  <center>
    <div style="background-color: #4CAF50; height: 45px; width: 100%; align-items: center; color: white; "><h1>Login</h1></div>
  <br><br>
  <hr class="colorgraph">
  <form action="Login" method="post">
    <table cellspacing="25">
      <col width="80%">
      <tr>
        <td>
          <input type="text" name="user" class="question" id="user" required autocomplete="off" />
          <label for="id"><span>User ID</span></label>
        </td>
      </tr>
      <tr>
        <td>
          <input type="password" name="password" class="question" id="password" required autocomplete="off" />
          <label for="password"><span>Password</span></label>
        </td>
      </tr>
  
    </table>
    <hr class="colorgraph">
    <br>
    <p style="color:red">${error}</p>
    <input type="submit" name="submit" value="Submit" style="height: 45px; width: 200px; font-size: 25px; color: white; background-color: #4CAF50">
  </form>
  </center>
</body>
</html>