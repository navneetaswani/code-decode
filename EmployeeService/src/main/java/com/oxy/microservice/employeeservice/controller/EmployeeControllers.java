package com.oxy.microservice.employeeservice.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.ImmutableList;
import com.oxy.microservice.employeeservice.dto.Employee;
import com.oxy.microservice.employeeservice.service.EmployeeService;

import io.swagger.annotations.ApiOperation;

@RestController
public class EmployeeControllers {
	
	@Autowired
	EmployeeService empService;

	@GetMapping("/hello")
	public String helloEmployee() {
		Set<String> uniqNames = new HashSet<>();
		 
		 System.out.println(uniqNames.add("Navneet"));
		 System.out.println(uniqNames.add("Navneet"));
		 
		 
		 final List<Integer> numbers = ImmutableList.of(1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9,10,11);

		    Set<Integer> distinctNumbers = numbers.stream().collect(Collectors.toSet());
		    
		    Set<Integer> uniqNumbers = new HashSet<>();
		    
		    Set<Integer> duplicate = numbers.stream().filter(num -> !uniqNumbers.add(num)).collect(Collectors.toSet());
		    Set<Integer> numg5 = numbers.stream().filter(num -> num >5 && num%2 == 0).collect(Collectors.toSet());

		    System.out.println(uniqNumbers);
		    System.out.println(duplicate);
		    System.out.println(numg5);
		 
		return "Hello Employee Controller";
	}

	@GetMapping("/employee/{empId}")
	public Optional<Employee> getEmployeeByEmpID(@PathVariable("empId") Long empId) {		
		 System.out.println("Hello Employee Controller : " + empId);
		return empService.getEmployeeById(empId);
		
	}

	@GetMapping("/getemployees")
	public List<Employee> getEmployees() {
		 System.out.println("Hello getEmployees");		
		return empService.getAllEmployees();
	}

	@RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT,consumes = "application/json", produces = "application/json")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return empService.updateEmployee(employee);
	}

	@ApiOperation(value = "Add a product")
	@CrossOrigin
	@RequestMapping(value = "/postemployee", method = RequestMethod.POST,consumes = "application/json", produces = "application/json")
	public Employee createEmployee(@RequestBody Employee employee) {
		return empService.addEmployee(employee);
	}

	@DeleteMapping("/deleteemployee/{empId}")
	public void deleteemployee(@PathVariable Long empId) {
		System.out.println("Delete employee : "+empId);
		 empService.deleteEmployee(empId);
	}

}
