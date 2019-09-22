package com.vir.service;

import java.util.List;

import com.vir.dao.EmployeeDao;
import com.vir.dao.EmployeeDaoInterface;
import com.vir.model.Employee;
public class EmployeeServiceImpl implements  EmployeeService{
	EmployeeDaoInterface empDao=new EmployeeDao();

	@Override
	public String addEmp(Employee employee) {
		// TODO Auto-generated method stub
		return empDao.addEmp(employee);
	}

	@Override
	public String authenticateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.authenticateEmp(emp);
	}

	@Override
	public Employee getEmployeeById(int empid) {
		// TODO Auto-generated method stub
		return empDao.getEmployeeById(empid);
	}

	@Override
	public int updateEmp(Employee emp) {
		// TODO Auto-generated method stub
		return empDao.updateEmp(emp);
	}

	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		return empDao.getAllEmployee();
	}

	
}
	
	

	


