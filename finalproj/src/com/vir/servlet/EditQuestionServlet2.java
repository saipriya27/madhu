package com.vir.servlet;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.vir.model.Question;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
@WebServlet("/EditQuestionServlet2")
public class EditQuestionServlet2 extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int empid=Integer.parseInt(request.getParameter("empid"));
		int qid=Integer.parseInt(request.getParameter("qid"));
		String qdesc=request.getParameter("qdesc");
		Question e=new Question();
		e.setQid(qid);
		e.setEmpid(empid);
		e.setQdesc(qdesc);
		QuestionServiceInterface qs= new QuestionInterfaceImpl();
		int status=qs.update(e);
		if(status>0){
			response.sendRedirect("ViewQuestionServlet");
		}else{
			out.println("Sorry! unable to update record");
		}
		
		out.close();
	}

}
