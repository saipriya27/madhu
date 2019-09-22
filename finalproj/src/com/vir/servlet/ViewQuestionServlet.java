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

import com.vir.model.Question;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
@WebServlet("/ViewQuestionServlet")
public class ViewQuestionServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		request.getRequestDispatcher("ProfileHome.html").include(request, response);  
		
		out.print("<a href='addQuestion.html'>Add New question</a>");
		out.println("<h1>Questions List</h1>");
		QuestionServiceInterface qs= new QuestionInterfaceImpl();
		
		 
		List<Question> list=qs.getAllQuestion();
		

	
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>qId</th><th>empid</th><th>qdesc</th><th>Action</th></tr>");
		for(Question e:list){
			out.print("<tr><td align=center>"+e.getQid()+"</td><td align=center>"+e.getEmpid()+"</td><td align=center>"+e.getQdesc()+"</td><td align=center><a href='EditQuestionServlet?qid="+e.getQid()+"'>view</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
	}
}
