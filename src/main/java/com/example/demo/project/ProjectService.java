package com.example.demo.project;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.employee.Employee;
import com.example.demo.employee.EmployeeRepository;

@Service
public class ProjectService {
	
	private final ProjectRepository projectRepository;
	
	@Autowired
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}


	public List<Project> getProjects () {
		return projectRepository.findAll();
	}
	
	public void registerNewProject(Project project) {
		// Set today date
		project.setProjectStartDate(LocalDate.now());
		System.err.println(LocalDate.now());
		// Check for date
		ProjectRepository.checkDueDate(project.getProjectStartDate(), project.getProjectDueDate());
		
		projectRepository.save(project);
	}

}

