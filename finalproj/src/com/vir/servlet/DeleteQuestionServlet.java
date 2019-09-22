package com.vir.servlet;

import java.io.IOException;  
import javax.servlet.ServletException;  
import javax.servlet.annotation.WebServlet;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.vir.model.Employee;
import com.vir.service.QuestionInterfaceImpl;
import com.vir.service.QuestionServiceInterface;
import com.vir.service.EmployeeService;
import com.vir.service.EmployeeServiceImpl;  
@WebServlet("/DeleteQuestionServlet")  
public class DeleteQuestionServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
             throws ServletException, IOException {  
     
        int qid=Integer.parseInt(request.getParameter("qid"));  
        QuestionServiceInterface qs= new QuestionInterfaceImpl();
        qs.deleteQuestion(qid);
        response.sendRedirect("ViewQuestionServlet");  
    }  
}  