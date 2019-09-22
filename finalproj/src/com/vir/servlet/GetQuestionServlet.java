package com.vir.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.vir.model.Question;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;

/**
 * Servlet implementation class GetQuestionServlet
 */
@WebServlet("/GetQuestionServlet")
public class GetQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetQuestionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		QuestionServiceInterface qs= new QuestionInterfaceImpl();
		List<Question> list=new ArrayList<Question>();
		System.out.println("before:"+list.size());
		list=qs.getAllQuestion();
		System.out.println("after:"+list.size());
		request.setAttribute("questionlist",list);
		RequestDispatcher rd=request.getRequestDispatcher("ViewQuestion.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
