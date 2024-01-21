package com.employee.directory.thymeleafCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.directory.thymeleafCrud.entity.Employee;
import com.employee.directory.thymeleafCrud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeController(EmployeeService service) {
		employeeService = service;
	}
	
	// to get all employee list
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	// to get 1 employee details
	@GetMapping("/employees/{employeeId}")
	public Employee getEmployee(@PathVariable int employeeId) {
		Employee emp = employeeService.findById(employeeId);
		if(emp == null) {
			throw new RuntimeException("Employee not found by id " + employeeId);
		}
		return emp;
	}
	
	// add new employee
	@PostMapping("employees")
	public Employee addEmployee(@RequestBody Employee theEmployee) {
		theEmployee.setId(0);
		Employee emp = employeeService.addUpdateEmployee(theEmployee);
		return emp;
		
	}
	
	//update employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee) {
		Employee emp = employeeService.addUpdateEmployee(theEmployee);
		return emp;
		
	}
	
	//delete employee
	@DeleteMapping("/employees/{employeeId}")
	public String deleteEmployee(@PathVariable int employeeId) {
		Employee emp = employeeService.findById(employeeId);
		if(emp == null) {
			throw new RuntimeException("Employee not found by id " + employeeId);
		}
		employeeService.deleteById(employeeId);
		return "Deleted employee Id " + employeeId;
		
	}
}
