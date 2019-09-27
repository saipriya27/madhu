package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vir.model.Answer;
import com.vir.model.Question;

public class AnswerDaoImpl implements AnswerDao{

	@Override
	public String addAns(Answer ans) {
		int empid=ans.getEmpid();
		int qid = ans.getQid();
		String ansDesc= ans.getAns_desc();
		int ansid=ans.getAns_id();
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try
		{  
			con = DBConnection.createConnection();
		 final String query = "insert into answer(qid,empid,ans) values(?,?,?)"; //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1,qid);
			preparedStatement.setInt(2,empid);
			preparedStatement.setString(3,ansDesc);
			int i= preparedStatement.executeUpdate();
			if (i!=0)  //Just to ensure data has been inserted into the database
				return "SUCCESS"; 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		
		}
		return "Oops.. Something went wrong there..!";  // On failure, send a message from here.
	}

		

	@Override
	public int deleteAns(int ans_id) {
		
		return 0;
	}

	@Override
	public int editAns(Answer a) {
		
		return 0;
	}



	@Override
	public List<Answer> getAllAnswer(int qid) {
List<Answer> list=new ArrayList<Answer>();  
        
        try{  
        	Connection con = DBConnection.createConnection(); 
            PreparedStatement ps=con.prepareStatement("select empid,ans from Answer where qid=?");  
            ps.setInt(1, qid);
            ResultSet rs=ps.executeQuery();  
            Answer Answer=new Answer(); 
            while(rs.next()){  
            	Answer.setEmpid(rs.getInt(1));
            	Answer.setAns_desc(rs.getString(2));
            	list.add(Answer);
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;
	}

}
