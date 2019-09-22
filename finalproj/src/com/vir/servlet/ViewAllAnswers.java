package com.vir.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vir.model.Answer;
import com.vir.model.Question;
import com.vir.service.AnswerService;
import com.vir.service.AnswerServiceImpl;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
@WebServlet("/ViewAllAnswers")
public class ViewAllAnswers extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String sid=request.getParameter("qid");

		int qid=Integer.parseInt(sid);
		HttpSession session=request.getSession();
		session.setAttribute("qid",qid); 
		
		
		request.getRequestDispatcher("ProfileHome.html").include(request, response);  
		
		out.print("<a href='addQuestion.html'>Add New question</a>");
		out.println("<h1>Answers</h1>");
	
		
		/*int qid=(Integer) session.getAttribute("qid");*/
		  
		
		AnswerService answerservice=new AnswerServiceImpl();
		 
		List<Answer> list=answerservice.getAllAnswer(qid);

	
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>empid</th><th>qdesc</th></tr>");
		for(Answer e:list){
			out.print("<tr><td align=center>"+e.getEmpid()+"</td><td align=center>"+e.getAns_desc()+"</td></tr>");
		}
		out.print("</table>");
		
		
		
		out.close();
	}
}


