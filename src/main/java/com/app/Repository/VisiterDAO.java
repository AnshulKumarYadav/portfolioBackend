package com.app.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.Model.Visiter;

@Repository
public interface VisiterDAO extends JpaRepository<Visiter, Integer> {
	
	public List<Visiter> findAllByEmail(String email);

}
