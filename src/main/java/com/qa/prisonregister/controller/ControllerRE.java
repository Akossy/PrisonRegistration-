package com.qa.prisonregister.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prisonregister.prisonreg.PrisonRegister;
import com.qa.prisonregister.services.ServiceDB;
import com.qa.prisonregister.services.Services;

@RestController
public class ControllerRE {

	//private ArrayList<PrisonRegister>  registerList = new ArrayList<> ();
	
	
	
	private ServiceDB service;
	
	
	public ControllerRE(ServiceDB service) {
		super();
		this.service = service;
	}

	
	@PostMapping("/createRegister")
	public ResponseEntity<String> createRegister(@RequestBody PrisonRegister register) {
		System.out.println(register);
		
	
		//register.setId(registerList.size() + 1);
		//registerList.add(register);
		
		service.createRegister(register);

		ResponseEntity<String> response = new ResponseEntity<String>("Prisoner added with ID: " + register.getPrisonerId(), HttpStatus.CREATED);
		return response;
	
}
	
	@GetMapping ("/getRegister")
	public ResponseEntity<List<PrisonRegister>> getRegister() {
		
		
		List<PrisonRegister> response = service.getRegister();
		
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		
	}
	
	
	@GetMapping("/getID/{id}")
	public ResponseEntity<PrisonRegister> getbyId(@PathVariable("id") long id) {
		
		PrisonRegister result = service.getbyId(id);
		
		ResponseEntity<PrisonRegister> response = new ResponseEntity<>(result, HttpStatus.OK);
	
		return response;
}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable("id") long id) {
		
		service.remove(id);
		
		return new ResponseEntity<>("Prisoner information with id " + id + " deleted", HttpStatus.ACCEPTED);
		
}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		
		service.clear();
		
		return new ResponseEntity<>("All Prisoner information deleted. If this action was made in error or as a result of a cyber attack, remove portable harddrive, report to Cyber Unit", HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping ("/update/{id}")
	public ResponseEntity<String> updatebyid(@PathVariable("id") long id, @RequestBody PrisonRegister register) {
		
		service.set(id, register);
		
		return new ResponseEntity<>("Prisoner " + id + " information updated. ", HttpStatus.OK);
		
		
	}

}
	
		
