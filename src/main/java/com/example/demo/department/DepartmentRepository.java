package com.example.demo.department;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;
import com.example.demo.extensions.*;


@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	List<ErrorMessageHandler> result = new ArrayList<>();

	
	public static void checkForEmployee(EmployeeRepository employeeRepository, long employeeID) {
		if(!employeeRepository.existsById(employeeID)) {
			new ErrorMessageHandler(false, "Manager dose not exists!");
		}
	}
	
	


	public static Double calculateEmployeeSalary(EmployeeRepository employeeRepository, Long departmentID) {
		List<Employee> employees = new ArrayList<>();
		double sum = 0;
		employees = employeeRepository.findByDepartmentID(departmentID);
		for(Employee employee : employees) {
			sum += employee.getSalary();
		}
		return sum;
	}
	
	

	
}
