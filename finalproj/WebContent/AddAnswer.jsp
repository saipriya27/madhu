<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%		  
        int empid=(Integer) session.getAttribute("empid"); 
        int qid=(Integer) session.getAttribute("qid");
 %>
 <form action=AddAnswerServlet method=post>
<table>
<tr><td>emp id :</td><td><input type='text' name='empid' value=<%=empid %>  readonly/></td></tr>
<tr><td>qid :</td><td><input type='text' name='qid' value=<%=qid %>  readonly/></td></tr>
<tr><td>Enter A ans :</td><td> <textarea rows='5' cols='15' name='ansdesc'></textarea></td></tr>
<tr><td></td><td><input type='submit' value='Send'></td></tr>
</table>
</form>
</body>
</html>