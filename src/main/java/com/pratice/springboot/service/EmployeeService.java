package com.pratice.springboot.service;

import java.util.List;

import com.pratice.springboot.domain.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);	
	Employee updateEmployee(Employee employee,long id);
	void deleteEmployee(Long id);
	

}
