package com.vir.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	 
	 
	 public static Connection createConnection()
	 {
	 Connection con = null;
	 String url = "jdbc:oracle:thin:@localhost:1521:xe"; //Oracle URL followed by the database name
	 String username = "system"; //Oracle username
	 String password = "manager"; //Oracle password
	 
	 try 
	 {
	 try 
	 {
	 Class.forName("oracle.jdbc.OracleDriver"); //loading Oracle drivers. This differs for database servers 
	 } 
	 catch (ClassNotFoundException e)
	 {
	 e.printStackTrace();
	 }
	 
	 con = DriverManager.getConnection(url, username, password); //attempting to connect to MySQL database
	 System.out.println("Printing connection object "+con);
	 } 
	 catch (Exception e) 
	 {
	 e.printStackTrace();
	 }
	 
	 return con; 
	 }
	}



