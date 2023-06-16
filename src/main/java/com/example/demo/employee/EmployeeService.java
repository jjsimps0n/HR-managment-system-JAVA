package com.example.demo.employee;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.extensions.ErrorMessageHandler;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}


	public List<Employee> getEmployees () {
		return employeeRepository.findAll();
	}

	
	public void addNewEmployee(Employee employee) {
		
		EmployeeRepository.validateName(employee.getName());
		EmployeeRepository.validateSalary(employee.getSalary(), 22000, 40000);
		
		String employeeName = EmployeeRepository.manipulateName(employee.getName());
		employee.setName(employeeName);
		employeeRepository.save(employee);
	}
}
