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
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
@WebServlet("/EditQuestionServlet")
public class EditQuestionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<h1>Update question</h1>");
		
		String sid=request.getParameter("qid");

		int qid=Integer.parseInt(sid);
		QuestionServiceInterface qs= new QuestionInterfaceImpl();
		Question e=qs.getEmployeeById(qid);
		
		HttpSession session=request.getSession();
		session.setAttribute("qid",qid); 
		
		out.print("<form action='EditQuestionServlet2' method='post'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='qid' value='"+e.getQid()+"'/></td></tr>");
		out.print("<tr><td>empid:</td><td><input type='number' name='empid' value='"+e.getEmpid()+"' readonly/></td></tr>");
		out.print("<tr><td>qdesc:</td><td><textarea rows='5' cols='80'>"+e.getQdesc()+"</textarea></td></tr>");
		out.print("<br>");
		out.print("<br>");
		
		out.print("</table>");
		out.print("</form>");
		
		out.print("<form action='AddAnswer.jsp' method='post'>");
		out.print("<tr><td colspan='2'><input type='submit' value='Add Answer '/></td></tr>");
		
		out.print("</form>");
		
		
	
	     out.print("<a href='ViewAllAnswers'>view answers</a>");  
		
		
		
		out.close();
	}
}
