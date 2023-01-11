package com.oxy.microservice.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oxy.microservice.employeeservice.dto.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
