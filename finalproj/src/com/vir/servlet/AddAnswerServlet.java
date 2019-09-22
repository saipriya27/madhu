package com.vir.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vir.model.Answer;
import com.vir.model.Employee;
import com.vir.model.Question;
import com.vir.service.QuestionServiceInterface;
import com.vir.service.AnswerService;
import com.vir.service.AnswerServiceImpl;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;
import com.vir.service.QuestionInterfaceImpl;
@WebServlet("/AddAnswerServlet")  
public class AddAnswerServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession(false);  
		if(session!=null){  

			int empid=(Integer) session.getAttribute("empid"); 
			int qid=(Integer) session.getAttribute("qid");
		  
			String ans_desc= request.getParameter("ansdesc");
			
			Answer answer=new Answer();
			
			answer.setAns_desc(ans_desc);
			answer.setEmpid(empid);
			answer.setQid(qid);
			
			AnswerService answerservice=new AnswerServiceImpl();
			String str=answerservice.addAns(answer);
			
			if(str.equals("SUCCESS"))
			{
				request.getRequestDispatcher("/Homepage.html").forward(request, response);
			}
			else {
				request.getRequestDispatcher("/EmpLogin.jsp").forward(request, response);
			}
			
			out.close();
		}
	}
}

