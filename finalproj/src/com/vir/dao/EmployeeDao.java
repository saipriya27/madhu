package com.vir.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vir.model.Employee;
import com.vir.model.Question;


public class EmployeeDao implements EmployeeDaoInterface {

	public String addEmp(Employee employee)
	{
		int id=employee.getEmpid();
		String fullName = employee.getFullName();
		String email = employee.getEmail();
		String userName = employee.getUserName();
		String password = employee.getPassword();

		Connection con = null;
		PreparedStatement preparedStatement = null;
		String query = " insert into employee (empid, ename, email, username, password)"
		        + " values (?, ?, ?, ?, ?)";

		try  
		{
			con = DBConnection.createConnection();
			 //Insert user details into the table 'USERS'
			preparedStatement = con.prepareStatement(query); //Making use of prepared statements here to insert bunch of data
			preparedStatement.setInt(1,id);
			preparedStatement.setString(2, fullName);

			preparedStatement.setString(3, email);
			preparedStatement.setString(4, userName);
			preparedStatement.setString(5, password);

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
	public String authenticateEmp(Employee emp) {

			String userName = emp.getUserName(); //Keeping user entered values in temporary variables.
			String password = emp.getPassword();
			Connection con = null;
			Statement statement = null;
			ResultSet resultSet = null;
			String empid = "";
			String passwordDB = "";
			try
			{  String query="select empid,password from employee";
				con = DBConnection.createConnection(); //establishing connection
				statement = con.createStatement(); //Statement is used to write queries. Read more about it.
				resultSet = statement.executeQuery(query); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
				while(resultSet.next()) // Until next row is present otherwise it return false
				{
					empid = resultSet.getString("empid"); //fetch the values present in database
					passwordDB = resultSet.getString("password");
					if(empid.equals(empid) && password.equals(passwordDB))
					{
						return "SUCCESS"; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
					}
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
			return "Invalid user credentials"; // Just returning appropriate message otherwise

		}


	@Override
	public int updateEmp(Employee emp) {
		 Connection con = null;
		  int status=0;
		try{
			con = DBConnection.createConnection();
			PreparedStatement ps=con.prepareStatement("update Employee set EMPNAME=?,EMAIL=?,USERNAME=?,PASSWORD=? where EMPID=?");
			ps.setString(1,emp.getFullName());
			ps.setString(2,emp.getEmail());
			ps.setString(3,emp.getUserName());
			ps.setString(4,emp.getPassword());
			ps.setInt(5, emp.getEmpid());
			
			
			status=ps.executeUpdate();
			
			con.close();
		}catch(Exception ex){ex.printStackTrace();}
		
		return status;
	}
	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> list=new ArrayList<Employee>();  
	      
	      try{  
	      	Connection con = DBConnection.createConnection(); 
	          PreparedStatement ps=con.prepareStatement("select * from Employee  "); 
	      
	          ResultSet rs=ps.executeQuery();  
	          while(rs.next()){  
	        	  Employee employee=new Employee(); 
	          	employee.setEmpid(rs.getInt(1));
	          	employee.setFullName(rs.getString(2));
	          	employee.setEmail(rs.getString(3));
	          	employee.setUserName(rs.getString(4));
	          	employee.setPassword(rs.getString(5));
	          	list.add(employee);
	         
	          }  
	          con.close();  
	      }catch(Exception e){e.printStackTrace();}  
	        
	      return list;  
	}

	@Override
	public Employee getEmployeeById(int empid) {
		 Employee employee=new Employee(); 
		try{  
	      	Connection con = DBConnection.createConnection(); 
	          PreparedStatement ps=con.prepareStatement("select * from Employee where empid=?"); 
	          ps.setInt(1, empid);
	          ResultSet rs=ps.executeQuery();  
	          while(rs.next()){  
	        	 
	        	  employee.setEmpid(rs.getInt(1));
		          	employee.setFullName(rs.getString(2));
		          	employee.setEmail(rs.getString(3));
		          	employee.setUserName(rs.getString(4));
		          	employee.setPassword(rs.getString(5));
	          
	         
	          }  
	          con.close();  
	      }catch(Exception e2){e2.printStackTrace();}  
	        
	      return employee;  

		
	}


	}
	


	