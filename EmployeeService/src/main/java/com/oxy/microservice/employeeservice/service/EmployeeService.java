package com.oxy.microservice.employeeservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oxy.microservice.employeeservice.dto.Employee;
import com.oxy.microservice.employeeservice.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository empRepo;

	public Optional<Employee> getEmployeeById(Long id) {
		return empRepo.findById(id);
	};
	
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	};
	
	public void deleteEmployee(Long id) {
		empRepo.deleteById(id);
	}

	public Employee addEmployee(Employee employee) {
		return empRepo.save(employee);
	}

	public Employee updateEmployee(Employee employee) {
		return empRepo.save(employee);
	};
}
