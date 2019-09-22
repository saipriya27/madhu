package com.vir.model;

public class Employee {
	private int empid;
	 private String fullName;
	
	private String email;
	 private String userName;
	 private String password;
	 
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getUserName() {
	 return userName;
	 }
	 public void setUserName(String userName) {
	 this.userName = userName;
	 }
	 public String getPassword() {
	 return password;
	 }
	 public void setPassword(String password) {
	 this.password = password;
	 }
	 public void setFullName(String fullName) {
	 this.fullName = fullName;
	 }
	 public String getFullName() {
	 return fullName;
	 }
	 public void setEmail(String email) {
	 this.email = email;
	 }
	 public String getEmail() {
	 return email;
	 }
	

	}
