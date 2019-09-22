
package com.vir.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vir.dao.EmployeeDao;
import com.vir.model.Employee;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;

@WebServlet("/EmpLoginServlet")

public class EmpLoginServlet extends HttpServlet {

public EmpLoginServlet() {
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



int empid =Integer.parseInt(request.getParameter("empid"));
String password = request.getParameter("password");

Employee loginBean = new Employee(); 

loginBean.setEmpid(empid);
loginBean.setPassword(password);

HttpSession session=request.getSession();
session.setAttribute("empid",empid);  

EmployeeService es = new EmployeeServiceImpl(); 

String userValidate = es.authenticateEmp(loginBean); 

if(userValidate.equals("SUCCESS")) 
{
request.setAttribute("empid", empid); 
request.getRequestDispatcher("/Homepage.html").forward(request, response);
}
else
{
request.setAttribute("errMessage", userValidate); 
request.getRequestDispatcher("/EmpLogin.jsp").forward(request, response);
}
}

}