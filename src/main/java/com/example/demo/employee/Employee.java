package com.example.demo.employee;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {
	@Id
	@SequenceGenerator(
			name = "employee_sequence",
			sequenceName = "employee_sequence",
			allocationSize = 1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "employee_sequence"
	)
	@Column(name = "employee_id")
    private long employeeId;
    private String name;
    private String role;
    private double salary;
    @Column(name = "department_id")
    private long departmentID;
    
    public Employee() {
    	
    }
    
	public Employee(long employeeId, String name, String role, double salary) {
		this.employeeId = employeeId;
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	
	public Employee(String name, String role, double salary) {
		this.name = name;
		this.role = role;
		this.salary = salary;
	}
	
	public long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", name=" + name + ", role=" + role + ", salary=" + salary + "]";
	}
    
}
