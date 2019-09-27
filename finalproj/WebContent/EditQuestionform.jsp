<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="com.vir.service.*,com.vir.model.*;"%>  
  
<%  
String qid=request.getParameter("qid");
QuestionServiceInterface qs= new QuestionInterfaceImpl(); 
Question e=qs.getEmployeeById(Integer.parseInt(qid));

session.setAttribute("qid",qid); 

%>  
  
<h1>Edit Form</h1>  
<form action="EditQuestion.jsp" method="post">  
<input type="hidden" name="qid" value="<%=e.getQid() %>"/>  
<table>  
<tr><td>empid:</td><td>  
<input type="text" name="name" value="<%=e.getEmpid()%>"/></td></tr>  
<tr><td>qdesc:</td><td>
<textarea rows="5" cols="80">"+e.getQdesc()+"</textarea></td></tr> 
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  