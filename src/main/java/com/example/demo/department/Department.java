package com.example.demo.department;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Department {
	@Id
	@SequenceGenerator(
			name = "department_sequence",
			sequenceName = "department_sequence",
			allocationSize = 1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "department_sequence"
	)
	@Column(name = "department_id")
    private long departmentId;
	
	@Column(name = "department_name")
    private String departmentName;
	
    private long managerId;
	
	@Column(name = "list_of_employees")
    private int listOfEmployees;
	
	public Department() {

	}
	
	

	public Department(String departmentName, long managerId, int listOfEmployees) {
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.listOfEmployees = listOfEmployees;
	}



	public Department(long departmentId, String departmentName, long managerId, int listOfEmployees) {
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.managerId = managerId;
		this.listOfEmployees = listOfEmployees;
	}



	public long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public long getManagerId() {
		return managerId;
	}

	public void setManagerId(long managerId) {
		this.managerId = managerId;
	}

	public int getListOfEmployees() {
		return listOfEmployees;
	}

	public void setListOfEmployees(int listOfEmployees) {
		this.listOfEmployees = listOfEmployees;
	}
	
	
    

    
}
