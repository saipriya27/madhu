
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
  background-color: lightblue;
}

h1 {
  color: black;
  text-align: center;
}

p {
  font-family: verdana;
  font-size: 20px;
}
</style>
</head>
<body>
<script> 
function validate()
{ 
 var username = document.form.username.value; 
 var password = document.form.password.value;
 
 if (username==null || username=="")
 { 
 alert("Username cannot be blank"); 
 return false; 
 }
 else if(password==null || password=="")
 { 
 alert("Password cannot be blank"); 
 return false; 
 } 
}
</script> 
<form action="EmpLoginServlet" method="post" onsubmit="return validate()">
<center>
<h1> &emsp;VFORUM</h1>


<h2> &emsp;&ensp; LOGIN </h2>
</center>

<center>
empId: &ensp;<input type="text" style="background-color:white;color:black;" name="empid">
<br>
<br>

Password:  &ensp; <input type="password" style="background-color:white;color:black;" name="password">
<br><br>
 <span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
 : request.getAttribute("errMessage")%></span>
 
 

<input type="submit" style="background-color:black;color:white;width:150px;
height:40px;" value="Login">

&emsp;

<input type="reset" style="background-color:black;color:white;width:150px;
height:40px;" value="Reset"><br>
<br>

<a href='Register.jsp'> New user..?</a href>

</center>
</form>

</body>
</html>
