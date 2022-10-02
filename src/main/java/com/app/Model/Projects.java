package com.app.Model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Projects {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer projectId;
	private String projectName;
	private String imageLink;
	private String repositoryLink;
	private String projectDescroption;
	private String liveDemoLink;
	private String projectType;

	@OneToMany(cascade = CascadeType.ALL)
	private List<TechStacks> techStacks;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Categories> categories;

}
