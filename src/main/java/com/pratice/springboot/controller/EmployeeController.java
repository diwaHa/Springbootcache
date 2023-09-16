package com.pratice.springboot.controller;



import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pratice.springboot.domain.Employee;
import com.pratice.springboot.service.EmployeeService;

@RestController

@RequestMapping("/api/employees")
//Employee controller is depends on employeeservice

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
		
	
	
	//now need to build rest api
	// postmapping contain employee json object that we need to bind to java object so we use @requestbody annotation
	//y adding response entity that we can provide complete status of the class like HEADER,ETC
	
	
	@PostMapping("employee")												//this post object will receive employee jason from postmapping annotation by calling responsebody annotation
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee )
	{
		employee.setEmail(employee.getEmail());
		employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setPhoneNum(employee.getPhoneNum());
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	//build get all employee RESTAPI
	
	@GetMapping
	public List<Employee> getEmployees()
	{
		return employeeService.getAllEmployees();
	}
	//build get employee by id REST API
	//http://localhost:8080/api/employee/1
	
	@GetMapping("{id}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") long employeeid){
		 
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(employeeid),HttpStatus.OK);
		
	}
	
	//build update employee REST API
	
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee)
	{
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		
	}
	
	//build delete employee REST API 
	//http:localhost:8080/api/employee/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		//delete employee from DB
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted succesfully",HttpStatus.OK);
	
}
}