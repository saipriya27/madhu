
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="com.vir.service.*,com.vir.model.Question"%>  
 
<%  
QuestionServiceInterface qs= new QuestionInterfaceImpl();
int qid=Integer.parseInt(request.getParameter("qid"));  
 
Question question=qs.getEmployeeById(qid);

//HttpSession session=request.getSession();
session.setAttribute("qid",qid); 

%>  
 
<h1>Edit Form</h1>  
<form action="updated" method="post">  
<input type="hidden" name="qid" value="<%=question.getQid()%>"/>  
<table>  
<tr><td>Emp id:</td><td>  
<input type="text" name="empid" value="<%=question.getEmpid()%>"/></td></tr>  
<tr><td>Question desc:</td><td>  
<td><textarea rows='5' cols='80'>"+question.getQdesc()+"</textarea></td></tr>
  <tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
 
</body>
</html>
