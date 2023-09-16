package com.pratice.springboot.service.impl;



import static org.mockito.Mockito.clearAllCaches;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pratice.springboot.domain.Employee;
import com.pratice.springboot.exception.ResorceNotFoundException;
import com.pratice.springboot.repository.EmployeeRepository;
import com.pratice.springboot.service.EmployeeService;


//whenever you had service class u need to add service annotation

@CacheConfig
@Service	
public class EmployeeServiceImpl implements EmployeeService{

	// we gonna emplye repositary as a mandory
	
	private EmployeeRepository employeeRepository;
	
	//here we can also use autowired
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}	


	@Override
	
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}


//		// TODO Auto-generated method stub	
//		if(employees.isEmpty()) {
//			employees = fet
//		}
//private List<Employee> employees = new ArrayList<>();
	@Override
	
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	@Cacheable(cacheNames = "employees" , key = "#id")
	public Employee getEmployeeById(Long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {
			return employee.get();
		}else {
			 throw new ResorceNotFoundException("Employee", "ID", id 	);
		}
	}


	@Override
	@CachePut(cacheNames = "employees" , key = "#employee.id")
	public Employee updateEmployee(Employee employee, long id) {
		//we need to check whether employee	given id is exist in DB or not
//		Optional<Employee>  = employeeRepository.findById(id);
//		if (employee1.isPresent()) {
//		employee.setFirstName(null);;	 
//			
//		}else {
//			throw new ResorceNotFoundException("Employee", "Id", id);
//			
//		}
		//lambdha function used below
//		
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(
				() ->new ResorceNotFoundException("Employee", "Id", id));
		
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		//save existing employee to DB
		employeeRepository.save(existingEmployee);
		return existingEmployee;
		
	}


	@Override
	@CacheEvict(cacheNames = "employees" , key = "#id")
	public void deleteEmployee(Long id) {
		//check whether the employee id exist or not
		employeeRepository.findById(id).orElseThrow(() 
		-> new ResorceNotFoundException(null, null, id));
		employeeRepository.deleteById(id);
		
	} 	
	

 
	

}
