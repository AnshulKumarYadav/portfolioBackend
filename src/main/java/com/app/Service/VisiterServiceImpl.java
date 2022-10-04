package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Model.Visiter;
import com.app.Repository.VisiterDAO;

@Service
public class VisiterServiceImpl implements VisiterService{
	
	@Autowired
	private VisiterDAO visiterDAO;

	@Override
	public Visiter takeVisitorRequest(Visiter visiter) {
            visiterDAO.save(visiter);
            return visiter;
	}

	@Override
	public String deleteVisitorRequest(String email) {
		List<Visiter> v = visiterDAO.findAllByEmail(email);
		visiterDAO.deleteAll(v);
		return "Visiter deleted";
	}

	@Override
	public List<Visiter> getAllVisitors() {
		List<Visiter> visterList = visiterDAO.findAll();
		return visterList;
	}

}
