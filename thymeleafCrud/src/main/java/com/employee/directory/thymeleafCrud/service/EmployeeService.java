package com.employee.directory.thymeleafCrud.service;

import java.util.List;

import com.employee.directory.thymeleafCrud.entity.Employee;

public interface EmployeeService {

	List<Employee> findAll();

	Employee findById(int employeeId);

	Employee addUpdateEmployee(Employee theEmployee);

	void deleteById(int employeeId);

}
