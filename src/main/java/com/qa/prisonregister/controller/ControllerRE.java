package com.qa.prisonregister.controller;

import java.util.ArrayList;

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
import com.qa.prisonregister.services.Services;

@RestController
public class ControllerRE {

	//private ArrayList<PrisonRegister>  registerList = new ArrayList<> ();
	
	
	
	private Services service;
	
	
	public ControllerRE(Services service) {
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
	public ResponseEntity<ArrayList<PrisonRegister>> getRegister() {
		
		
		ArrayList<PrisonRegister> response = service.getRegister();
		
		
		return new ResponseEntity<>(response, HttpStatus.ACCEPTED );
		
	}
	
	
	@GetMapping("/get/{index}")
	public ResponseEntity<PrisonRegister> getbyIndex(@PathVariable("index") int index) {
		
		PrisonRegister result = service.getbyIndex(index);
		
		ResponseEntity<PrisonRegister> response = new ResponseEntity<>(result, HttpStatus.OK);
	
		return response;
}
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<String> deletebyIndex(@PathVariable("index") int index) {
		
		service.remove(index);
		
		return new ResponseEntity<>("Prisoner information with index" + index + "deleted", HttpStatus.ACCEPTED);
		
}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		
		service.clear();
		
		return new ResponseEntity<>("All Prisoner information deleted. If this action was made in error or as a result of a cyber attack, remove portable harddrive, report to Cyber Unit", HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping ("/update/{index}")
	public ResponseEntity<String> updatebyIndex(@PathVariable("index") int index, @RequestBody PrisonRegister register) {
		
		service.set(index, register);
		
		return new ResponseEntity<>("Prisoner " + index + " information updated. ", HttpStatus.OK);
		
		
	}
}
		
