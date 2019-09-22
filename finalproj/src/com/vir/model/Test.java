package com.vir.model;

import java.util.ArrayList;

import com.vir.service.AnswerServiceImpl;
import com.vir.service.EmployeeServiceImpl;
import com.vir.service.QuestionInterfaceImpl;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	/*	AnswerServiceImpl e=new AnswerServiceImpl();
		ArrayList l=new ArrayList();
		l.add(e.getAllAnswer(5));
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i));
		}*/
		QuestionInterfaceImpl e=new QuestionInterfaceImpl();
		ArrayList l=new ArrayList();
		l.add(e.getAllQuestion());
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i));
		}
		
	}

}
