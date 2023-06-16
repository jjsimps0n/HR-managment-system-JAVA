package com.example.demo.project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.Employee;


@RestController
@RequestMapping(path = "api/v1/project")
public class ProjectController {
	private final ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	@GetMapping
	public List<Project> getProjects () {
		return projectService.getProjects();
	}
	
	@PostMapping
	public void registerNewProject(@RequestBody Project project) {
		projectService.registerNewProject(project);
	}
	
	@GetMapping(path = "{projectID}")
	public List<Project> getProjectParticipiantCount (@PathVariable("departmentID") Long projectID) {
		// Liko 8min.. nebepadarysiu.
		return projectService.getProjects();
	}

	
}
