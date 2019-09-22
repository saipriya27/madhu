package com.vir.dao;

import java.util.List;

import com.vir.model.Question;

public interface QuestionDaoInterface
{
	public String addQuestion(Question question);
	public int deleteQuestion(int qid);
	public Question getEmployeeById(int qid);
	public int update(Question e);
	public List<Question> getAllQuestion();
}
