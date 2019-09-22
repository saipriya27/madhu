package com.vir.dao;

import java.util.List;

import com.vir.model.Answer;
import com.vir.model.Question;

public interface AnswerDao {

	public String addAns(Answer a);
	public int deleteAns(int ans_id);
	public int editAns(Answer a);
	public List<Answer> getAllAnswer(int qid);
}
