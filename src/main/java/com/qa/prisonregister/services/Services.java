package com.qa.prisonregister.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.qa.prisonregister.prisonreg.PrisonRegister;
import com.qa.prisonregister.repo.Repo;

//@Service
public class Services {
	
	
	
	private Repo repo;
	
	
	public Services(Repo repo) {
		super();
		this.repo = repo;
	}

	
	public boolean createRegisterDB(PrisonRegister register) {
		repo.save(register);
		return true;
	}
	
	
	private ArrayList<PrisonRegister>  registerList = new ArrayList<> ();
	
	public boolean createRegister(PrisonRegister register) {
		
		register.setId(registerList.size() + 1);
		registerList.add(register);
		return true;
		
		
	}

	public PrisonRegister getbyIndex(int index) {
		return registerList.get(index);
		
	}

	public ArrayList<PrisonRegister> getRegister() {
		return registerList;
	}

	public boolean remove(int index) {
		registerList.remove(index);
		return true;
		
	}

	public boolean clear() {
		registerList.clear();
		return true;
		
	
	}

	public boolean set(int index, PrisonRegister register) {
		registerList.set(index, register);
		return true;
		
	}
	
	
	
	
	
}
