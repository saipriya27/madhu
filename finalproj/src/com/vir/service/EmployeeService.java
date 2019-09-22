package com.vir.service;

import java.util.List;

import com.vir.model.Employee;

public interface EmployeeService {
	public String addEmp(Employee employee);
	public String authenticateEmp(Employee emp);
	public Employee getEmployeeById(int empid);
	public int updateEmp(Employee emp);
	public List<Employee> getAllEmployee();

}
