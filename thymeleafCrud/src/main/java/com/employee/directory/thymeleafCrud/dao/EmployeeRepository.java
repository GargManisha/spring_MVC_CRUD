package com.employee.directory.thymeleafCrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.directory.thymeleafCrud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	//blank.. no need to write any code.
	
	// add a method to sort by last name
	public List<Employee> findAllByOrderByLastNameAsc();
}
