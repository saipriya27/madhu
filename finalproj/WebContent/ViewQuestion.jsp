<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.vir.model.*"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>
<h2>ALL APPLICATIONS Table</h2>
<form method="get" action="#">
<%
		
		List<Question> aj=(List<Question>)request.getAttribute("questionlist");
		//request.setAttribute("eid", request.getAttribute("eid"));
%>
				<table>
				  <tr>
				    <th>qidID</th>
				    <th>empID</th>
				    <th>qdesc</th>
				    <th>REVIEW</th>
				    
				  </tr>
				  <c:set var="cnt" value="0"></c:set>
				  
				  <%for(int j=0;j<aj.size();j++)
				    {
		          %>
				  <tr>
				    <td><%=aj.get(j).getQid()%></td>
				    <td><%=aj.get(j).getEmpid()%></td>
				    <td><%=aj.get(j).getQdesc()%></td>
				   
				   
				  </tr>
				  <%
				    }
		          %>
				</table>
</form>
</body>
</html>