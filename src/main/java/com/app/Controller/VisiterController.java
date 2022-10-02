package com.app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Visiter;
import com.app.Service.VisiterServiceImpl;

@RestController
@CrossOrigin
public class VisiterController {
	
	@Autowired
	private VisiterServiceImpl visiterServiceImpl;
	
	@PostMapping("/visiter")
	public Visiter takeVisiterDetails(@Valid @RequestBody Visiter visiter) {
		return visiterServiceImpl.takeVisitorRequest(visiter);
	}
	
	@DeleteMapping("/deleteVisiter")
	public Visiter deleteVisiterDetails(@Valid @PathVariable String email)
	{
		return visiterServiceImpl.deleteVisitorRequest(email);
	}
	
	@GetMapping("/visiters")
	public List<Visiter> getAllVisiters()
	{
		return visiterServiceImpl.getAllVisitors();
	}

}
