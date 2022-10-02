package com.app.Service;

import java.util.List;

import com.app.Model.Projects;

public interface ProjectsService {
	
	public Projects addProjects(Projects project);
	
	public List<Projects> getAllProjects();
	
	public Projects updateProjects(Projects projects);
	
	public Projects deleteProjects(String name);

}
