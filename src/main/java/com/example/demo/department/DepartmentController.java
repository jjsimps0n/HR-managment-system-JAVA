package com.example.demo.department;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/department")
public class DepartmentController {
	private final DepartmentService departmentService;
	
	@Autowired
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	@GetMapping
	public List<Department> getDepartments () {
		return departmentService.getDepartments();
	}
	
	@PostMapping
	public void registerNewDepartment(@RequestBody Department department) {
		departmentService.addNewDepartment(department);
	}
	
	@GetMapping(path = "{departmentID}")
	public List<Double> getAvgSalary(@PathVariable("departmentID") Long departmentID) {
		return departmentService.calculateAvgDepartmentSalary(departmentID);
	}
	
}
