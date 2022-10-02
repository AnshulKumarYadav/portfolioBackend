package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Projects;
import com.app.Service.ProjectsServiceImpl;

@RestController
@CrossOrigin
public class ProjectsController {
	
	@Autowired
	private ProjectsServiceImpl projectsServiceImpl;
	
	@PostMapping("/addProject")
	public Projects addProject(@RequestBody Projects project) {
		return projectsServiceImpl.addProjects(project);
	}
	
	@GetMapping("/getProjects")
	public List<Projects> getAllProject()
	{
		return projectsServiceImpl.getAllProjects();
	}
	
	@PutMapping("/updateProject")
	public Projects updateProject(@RequestBody Projects project) {
		return projectsServiceImpl.updateProjects(project);
	}
	
	@DeleteMapping("/deleteProject/{projectName}")
	public Projects deleteProject(@PathVariable String projectName)
	{
		return projectsServiceImpl.deleteProjects(projectName);
	}

}
