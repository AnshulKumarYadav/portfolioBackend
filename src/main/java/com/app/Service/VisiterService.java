package com.app.Service;

import java.util.List;

import com.app.Model.Visiter;

public interface VisiterService {
	
	public Visiter takeVisitorRequest(Visiter visiter);
	
	public String deleteVisitorRequest(String email);
	
	public List<Visiter> getAllVisitors();

}
