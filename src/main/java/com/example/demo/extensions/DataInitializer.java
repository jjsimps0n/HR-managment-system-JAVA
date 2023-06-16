package com.example.demo.extensions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.department.*;
import com.example.demo.employee.*;

@Component
public class DataInitializer implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    @Autowired
    public DataInitializer(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create employees
        Employee employee1 = new Employee("John Doe", "", 2000);
        Employee employee2 = new Employee("Jane Smith", "", 2000);

        // Save employees to the repository
        employeeRepository.save(employee1);
        employeeRepository.save(employee2);

        // Create departments
        //Department department1 = new Department();
        Department department2 = new Department("HR", 1, 2);

        // Save departments to the repository
        //departmentRepository.save(department1);
        departmentRepository.save(department2);
    }
}

