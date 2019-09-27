package com.vir.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vir.model.Employee;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;

@WebServlet("/UpdateEmpDetailsServlet")
public class UpdateEmpDetailsServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int empid= Integer.parseInt(request.getParameter("empid"));
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		Employee employee = new Employee();
		employee.setEmpid(empid);
		employee.setFullName(fullName);
		employee.setEmail(email);
		employee.setUserName(userName);
		employee.setPassword(password); 

		EmployeeService es = new EmployeeServiceImpl();


		int status=es.updateEmp(employee);
		if(status>0){
			out.println("updated");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}
	

}
