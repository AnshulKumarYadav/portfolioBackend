package com.app.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visiter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer visiterId;
	private String name;
	
	@Email
	private String email;
	private String subject;
	private String message;

}
