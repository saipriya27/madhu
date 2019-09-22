package com.vir.service;

import java.util.List;

import com.vir.model.Answer;

public interface AnswerService {
	public String addAns(Answer a);
	public int deleteAns(int ans_id);
	public int editAns(Answer a);
	public List<Answer> getAllAnswer(int qid);
}
