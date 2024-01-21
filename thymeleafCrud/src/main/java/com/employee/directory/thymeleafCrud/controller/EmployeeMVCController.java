package com.employee.directory.thymeleafCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.employee.directory.thymeleafCrud.entity.Employee;
import com.employee.directory.thymeleafCrud.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeMVCController {

	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeMVCController(EmployeeService theEmployeeService) {
		employeeService = theEmployeeService;
	}
	
	@GetMapping("/list")
	public String listEmployees(Model model) {
		
		// get emp from DB
		List<Employee> emp = employeeService.findAll();
		
		// add them to spring model
		model.addAttribute("employees", emp);
		
		return "list-employees";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		
		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employee-form";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee emp) {
		
		// save record.
		employeeService.addUpdateEmployee(emp);
		//use a redirect to prevent duplicate submission.
		return "redirect:/employees/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
		
		//get employee from DB
		Employee emp = employeeService.findById(id);
		
		//set employee in the model 
		model.addAttribute("employee", emp);

		return "employee-form";
	}

	@GetMapping("delete")
	public String delete(@RequestParam("employeeId") int id) {
		
		employeeService.deleteById(id);
		return "redirect:/employees/list";
	}
}



