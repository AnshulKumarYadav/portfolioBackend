package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Exception.ProjectsException;
import com.app.Model.Projects;
import com.app.Repository.ProjectsDAO;

@Service
public class ProjectsServiceImpl implements ProjectsService {
	
	@Autowired
	private ProjectsDAO projectsDAO;

	@Override
	public Projects addProjects(Projects project) {
		Projects existingProject = projectsDAO.findByProjectName(project.getProjectName());
		
		if(existingProject==null)
		{
			return projectsDAO.save(project);
		}
		throw new ProjectsException("Project already exists");
		
	}

	@Override
	public List<Projects> getAllProjects() {
		List<Projects> projectsList = projectsDAO.findAll();
		if(projectsList.isEmpty())
		{
			throw new ProjectsException("Projects are not in database please add first");
		}
		return projectsList;
	}

	@Override
	public Projects updateProjects(Projects projects) {
		Projects existingProject = projectsDAO.findByProjectName(projects.getProjectName());
		if(existingProject!=null)
		{
			existingProject.setImageLink(projects.getImageLink());
			existingProject.setProjectDescroption(projects.getLiveDemoLink());
			existingProject.setLiveDemoLink(projects.getProjectDescroption());
			existingProject.setRepositoryLink(projects.getRepositoryLink());
			existingProject.setCategories(projects.getCategories());
			existingProject.setTechStacks(projects.getTechStacks());
			existingProject.setProjectType(projects.getProjectType());
			return projectsDAO.save(existingProject);
		}
		throw new ProjectsException("Project does not exists");
	}

	@Override
	public Projects deleteProjects(String Name) {
		
		Projects existingProject = projectsDAO.findByProjectName(Name);
		if(existingProject!=null)
		{
			 projectsDAO.delete(existingProject);
			 return existingProject;
		}
		throw new ProjectsException("Project does not exists");
		
	}

}
