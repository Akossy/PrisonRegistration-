package com.qa.prisonregister.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prisonregister.prisonreg.PrisonRegister;


//@RestController
public class Controller {

	//private ArrayList<PrisonRegister>  registerList = new ArrayList<> ();
	
	@GetMapping ("/getRegister")
	public ArrayList<PrisonRegister> registerList() {
		return registerList;
		

	}

	@PostMapping("/createSetRegister")
	public boolean createSetRegister(@RequestBody PrisonRegister register) {
		registerList.add(register);
		registerList.add(new PrisonRegister(1,"Bobby Smith", "Fraud","Fighting", "C", 5,24, false, false, false));
		return true;
	}
	
	@PostMapping("/createRegister")
	public boolean createRegister(@RequestBody PrisonRegister register) {
		System.out.println(register);
		
		
		
		register.setId(registerList.size() + 1);
		registerList.add(register);
		return true;
	
	}
	
	@GetMapping("/get/{index}")
	public PrisonRegister getbyIndex(@PathVariable("index") int index) {
		return registerList.get(index);
	
	}
	@DeleteMapping("/delete/{index}")
	public boolean deletebyIndex(@PathVariable("index") int index) {
		registerList.remove(index);
		return true;
	}
	
	@DeleteMapping("/deleteAll")
	public boolean deleteAll() {
		registerList.clear();
		return true;
	}
	
	@PutMapping ("/update/{index}")
	public boolean update(@PathVariable("index") int index, @RequestBody PrisonRegister register) {
		registerList.set(index, register);
		System.out.println("Prisoner " + index + " information updated. ");
		return true;
		
	}
}
	
	
}
	




    

	


