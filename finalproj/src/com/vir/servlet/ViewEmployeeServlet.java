package com.vir.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.model.Employee;
import com.vir.model.Question;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
@WebServlet("/ViewEmployeeServlet")
public class ViewEmployeeServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<a href='Register.jsp'>Add New Employee</a>");
		out.println("<h1>Questions List</h1>");
		  EmployeeService es = new EmployeeServiceImpl(); 
		List<Employee> list=es.getAllEmployee();
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>empid</th><th>ename</th><th>email</th><th>username</th><th>password</th></tr>");
		for(Employee e:list){
			out.print("<tr><td>"+e.getEmpid()+"</td><td>"+e.getFullName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getUserName()+"</td><td>"+e.getPassword()+"</td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
