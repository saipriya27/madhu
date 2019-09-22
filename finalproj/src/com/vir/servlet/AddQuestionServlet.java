package com.vir.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vir.model.Question;
import com.vir.service.QuestionServiceInterface;
import com.vir.service.QuestionInterfaceImpl;
@WebServlet("/AddQuestionServlet")  
public class AddQuestionServlet extends HttpServlet
{

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
		PrintWriter out=response.getWriter();
		//int qid= Integer.parseInt(request.getParameter("qid"));
		int empid= Integer.parseInt(request.getParameter("empid"));
		String qdesc =request.getParameter("qdesc");
		Question question = new Question();
		//question.setQid(qid);
		question.setEmpid(empid);
		question.setQdesc(qdesc);
		QuestionServiceInterface qs= new QuestionInterfaceImpl();
		String userRegistered = qs.addQuestion(question);

	    
		
		if(userRegistered.equals("SUCCESS"))   
		{
			out.print("<p>Record saved successfully!</p>");  
			request.getRequestDispatcher("addQuestion.html").include(request, response); 
		}
		else   
		{
			out.println("Sorry! unable to save record");  

		}
		out.close();
	}
}

