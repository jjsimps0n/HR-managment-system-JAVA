package com.example.demo.department;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.EmployeeRepository;
import com.example.demo.extensions.ErrorMessageHandler;


@Service
public class DepartmentService {
	List<ErrorMessageHandler> result = new ArrayList<>();
	private final DepartmentRepository departmentRepository;
	public EmployeeRepository employeeRepository;
	
	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
		this.departmentRepository = departmentRepository;
		this.employeeRepository = employeeRepository;
	}


	public List<Department> getDepartments () {
		return departmentRepository.findAll();
	}

	public void addNewDepartment(Department department) {
		DepartmentRepository.checkForEmployee(employeeRepository, department.getManagerId());	
		departmentRepository.save(department);
		
	}
	
	public List<Double> calculateAvgDepartmentSalary(Long departmentID) {
		if(!departmentRepository.existsById(departmentID)) {
			new ErrorMessageHandler(false, "Department does not exists!");
		};
		List<Double> salary = new ArrayList<>();
		salary.add(DepartmentRepository.calculateEmployeeSalary(employeeRepository, departmentID));
		return salary;
	}

}
