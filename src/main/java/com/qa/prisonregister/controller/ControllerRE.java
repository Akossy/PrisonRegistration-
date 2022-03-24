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

@RestController
public class ControllerRE {

	private ArrayList<PrisonRegister>  registerList = new ArrayList<> ();
	
	
	@PostMapping("/createRegister")
	public ResponseEntity<String> createRegister(@RequestBody PrisonRegister register) {
		System.out.println(register);
		
	
		register.setId(registerList.size() + 1);
		registerList.add(register);
		

		ResponseEntity<String> response = new ResponseEntity<String>("Prisoner added with ID: " + register.getPrisonerId(), HttpStatus.CREATED);
		return response;
	
}
	
	@GetMapping ("/getRegister")
	public ResponseEntity<ArrayList<PrisonRegister>> getRegister() {
		
		
		return new ResponseEntity<>(registerList, HttpStatus.ACCEPTED );
		
	}
	
	
	@GetMapping("/get/{index}")
	public ResponseEntity<PrisonRegister> getbyIndex(@PathVariable("index") int index) {
		
		PrisonRegister result = registerList.get(index);
		
		ResponseEntity<PrisonRegister> response = new ResponseEntity<>(result, HttpStatus.OK);
	
		return response;
}
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<String> deletebyIndex(@PathVariable("index") int index) {
		
		registerList.remove(index);
		
		return new ResponseEntity<>("Prisoner information with index" + index + "deleted", HttpStatus.ACCEPTED);
		
}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		
		registerList.clear();
		
		return new ResponseEntity<>("All Prisoner information deleted. If this action was made in error or as a result of a cyber attack, remove portable harddrive, report to Cyber Unit", HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping ("/update/{index}")
	public ResponseEntity<String> updatebyIndex(@PathVariable("index") int index, @RequestBody PrisonRegister register) {
		
		registerList.set(index, register);
		
		return new ResponseEntity<>("Prisoner " + index + " information updated. ", HttpStatus.OK);
		
		
	}
}
		
