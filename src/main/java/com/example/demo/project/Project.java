package com.example.demo.project;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Project {
	@Id
	@SequenceGenerator(
			name = "project_sequence",
			sequenceName = "project_sequence",
			allocationSize = 1
	)
	
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "project_sequence"
	)
	@Column(name = "project_id")
    private long projectId;
	@Column(name = "project_name")
	private String projectName;
	@Column(name = "project_start_date")
	private LocalDate projectStartDate;
	@Column(name = "project_due_date")
	private LocalDate projectDueDate;
	
	public Project() {

	}
	
	public Project(String projectName, LocalDate projectStartDate, LocalDate projectDueDate) {
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectDueDate = projectDueDate;
	}
	
	public Project(long projectId, String projectName, LocalDate projectStartDate, LocalDate projectDueDate) {
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectStartDate = projectStartDate;
		this.projectDueDate = projectDueDate;
	}
	
	public long getProjectId() {
		return projectId;
	}
	
	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public LocalDate getProjectStartDate() {
		return projectStartDate;
	}
	
	public void setProjectStartDate(LocalDate projectStartDate) {
		this.projectStartDate = projectStartDate;
	}
	
	public LocalDate getProjectDueDate() {
		return projectDueDate;
	}
	
	public void setProjectDueDate(LocalDate projectDueDate) {
		this.projectDueDate = projectDueDate;
	}
	

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", projectStartDate="
				+ projectStartDate + ", projectDueDate=" + projectDueDate + "]";
	}
	
	
 
  
    
}
