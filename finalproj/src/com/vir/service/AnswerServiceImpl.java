package com.vir.service;

import java.util.List;

import com.vir.dao.AnswerDao;
import com.vir.dao.AnswerDaoImpl;
import com.vir.model.Answer;

public class AnswerServiceImpl implements AnswerService{

	AnswerDao ans=new AnswerDaoImpl();
	@Override
	public String addAns(Answer a) {
		
		return ans.addAns(a);
	}

	@Override
	public int deleteAns(int ans_id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int editAns(Answer a) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Answer> getAllAnswer(int qid) {
		
		return ans.getAllAnswer(qid);
	}

}
