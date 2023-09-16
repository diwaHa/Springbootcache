package com.pratice.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pratice.springboot.domain.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long > {

}
