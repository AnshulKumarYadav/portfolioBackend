package com.app.Service;

import java.util.List;
import java.util.Optional;

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
	public String deleteVisitorRequest(Integer id) {
		Optional<Visiter> v = visiterDAO.findById(id);
		
		if(v.isPresent())
		{
			visiterDAO.delete(v.get());
			return "Visitor deleted";
		}
		else return "Visitor Not found";
		
	}
	
	@Override
	public String deleteAllVisitorsWithEmail(String email) {
		List<Visiter> v = visiterDAO.findAllByEmail(email);
		visiterDAO.deleteAll(v);
		return "Visiters deleted";
	}

	@Override
	public List<Visiter> getAllVisitors() {
		List<Visiter> visterList = visiterDAO.findAll();
		return visterList;
	}


}
