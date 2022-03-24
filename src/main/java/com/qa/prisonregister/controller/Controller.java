package com.qa.prisonregister.controller;

import java.util.ArrayList;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prisonregister.prisonreg.PrisonRegister;


@RestController
public class Controller {

	private ArrayList<PrisonRegister>  registerList = new ArrayList<> ();
	
	@GetMapping ("/getRegister")
	public ArrayList<PrisonRegister> registerList() {
		return registerList;
		

	}

	@PostMapping("/createRegister")
	public boolean createRegister(@RequestBody PrisonRegister register) {
		registerList.add(register);
		registerList.add(new PrisonRegister("Bobby Smith", "Fraud","Fighting", "C", 5,24, false, false, false));
		return true;
	}
	




    

	

}
