package com.pratice.springboot.domain;


import java.io.Serializable;

import jakarta.persistence.Column;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
	
@Data
@Entity
@Table(name = "employees")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8456322761826249653L;

	//need to assign id for primary key
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//nullable is boolean value were firstname should be mandatory other wise it shows as false
	
	@Column(name = "first_name", nullable = false)
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "email")
	private String email;
	@Column(name = "phnum")
	private long phoneNum;
	
	
	
	}
