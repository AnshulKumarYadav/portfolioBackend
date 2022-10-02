package com.app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Projects;

@Repository
public interface ProjectsDAO extends JpaRepository<Projects, Integer> {
	
	public Projects findByProjectName(String projectName);

}
