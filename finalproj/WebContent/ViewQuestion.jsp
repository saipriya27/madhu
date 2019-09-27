<!DOCTYPE html>  
  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
</head>  
<body>  
  
<%@page import="com.vir.model.*,com.vir.service.*,java.util.*"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Question List</h1>  
  
<%  
QuestionServiceInterface qs= new QuestionInterfaceImpl();

List<Question> list=qs.getAllQuestion(); 
request.setAttribute("list",list);  
%>  
  
<table border="1" width="90%">  
<tr><th>qid</th><th>empid</th><th>qdesc</th><th>Edit</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${u.getQid()}</td><td>${u.getEmpid()}</td><td>${u.getQdesc()}</td>   
<td><a href="EditQuestionServlet?qid=${u.getQid()}">view</a></td>  
</c:forEach>  
</table>  
<br/><a href="addQuestion.html">Add Question</a>  
  
</body>  
</html>  