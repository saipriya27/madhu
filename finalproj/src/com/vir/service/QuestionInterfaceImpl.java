package com.vir.service;

import java.util.List;

import com.vir.dao.EmployeeDao;
import com.vir.dao.EmployeeDaoInterface;
import com.vir.dao.QuestionDaoImpl;
import com.vir.dao.QuestionDaoInterface;
import com.vir.model.Question;

public class QuestionInterfaceImpl implements  QuestionServiceInterface{
	private QuestionDaoInterface questionDao=new QuestionDaoImpl();
	public String addQuestion(Question question) 
	{
		return questionDao.addQuestion(question);
	}


	

	public Question getEmployeeById(int qid) {
		// TODO Auto-generated method stub
		return questionDao.getEmployeeById(qid);
	}


	public int update(Question q) {
		// TODO Auto-generated method stub
		return questionDao.update(q);
	}


	public List<Question> getAllQuestion() {
		// TODO Auto-generated method stub
		return questionDao.getAllQuestion();
	}




	public int deleteQuestion(int qid) {
		// TODO Auto-generated method stub
		return questionDao.deleteQuestion(qid);
	}




	
	

	

}
