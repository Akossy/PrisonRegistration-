package com.qa.prisonregister.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.qa.prisonregister.prisonreg.PrisonRegister;
import com.qa.prisonregister.repo.Repo;

@Service
public class ServiceDB {

	
	private Repo repo;

	public ServiceDB(Repo repo) {
		super();
		this.repo = repo;
	}
	

	public boolean createRegister(PrisonRegister register) {
		repo.save(register);
		return true;
	}


	public PrisonRegister getbyId(long id) {
		return repo.findById(id).get();
	}


	public List<PrisonRegister> getRegister() {
		return repo.findAll();
	}


	public boolean clear() {
		repo.deleteAll();
		return true;
		
	}


	public boolean set(long id, PrisonRegister register) {
		
		PrisonRegister oldRegister = getbyId(id);
		
		oldRegister.setName(register.getName());
		oldRegister.setCrime(register.getCrime());
		oldRegister.setReasonInSolitaryConfinement(register.getReasonInSolitaryConfinement());
		oldRegister.setTotalPrisonSentenceInMonths(register.getTotalPrisonSentenceInMonths());
		oldRegister.setDaysinSolitaryConfinement(register.getDaysinSolitaryConfinement());
		oldRegister.setGangMember(register.isGangMember());
		oldRegister.setSuicideWatch(register.isSuicideWatch());
		oldRegister.setRepeatVisitor(register.isRepeatVisitor());
		
		
		PrisonRegister updateRegister = oldRegister;
		repo.save(updateRegister);
		
		return true;
		
	}


	public boolean remove(long id) {
		repo.deleteById(id);
		return true;
		
	}


	
	}
