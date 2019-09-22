package com.vir.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vir.model.Employee;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;

@WebServlet("/RegisterServlet")

public class EmpRegisterServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	public EmpRegisterServlet() {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id= Integer.parseInt(request.getParameter("Empid"));
		String fullName = request.getParameter("fullname");
		String email = request.getParameter("email");
		String userName = request.getParameter("username");
		String password = request.getParameter("password");

		Employee employee = new Employee();
		employee.setEmpid(id);
		employee.setFullName(fullName);
		employee.setEmail(email);
		employee.setUserName(userName);
		employee.setPassword(password); 

		EmployeeService es = new EmployeeServiceImpl();


		String userRegistered = es.addEmp(employee);

		if(userRegistered.equals("SUCCESS"))   
		{
			request.getRequestDispatcher("/EmpLogin.jsp").forward(request, response);
		}
		else   
		{
			request.setAttribute("errMessage", userRegistered);
			request.getRequestDispatcher("/Register.jsp").forward(request, response);
		}
	}
}