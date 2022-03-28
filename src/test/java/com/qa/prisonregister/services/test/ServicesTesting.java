package com.qa.prisonregister.services.test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import com.qa.prisonregister.prisonreg.PrisonRegister;
import com.qa.prisonregister.repo.Repo;
import com.qa.prisonregister.services.ServiceDB;

@SpringBootTest
@ActiveProfiles("dev")
public class ServicesTesting {

	
	@MockBean
	private Repo repo;
	
	@Autowired
	private ServiceDB service;
	
	PrisonRegister register1 = new PrisonRegister ("name1", "crime1", "reason1","a", 1, 1, true, true, true);
	PrisonRegister register2 = new PrisonRegister ("name2", "crime2","reason2","b", 2,  2, false, false, false);
	
	PrisonRegister registerID1 = new PrisonRegister (1l, "name1", "crime1", "reason1","a", 1, 1, true, true, true);
	PrisonRegister registerID2 = new PrisonRegister (2l, "name2", "crime2","reason2","b", 2,  2, false, false, false);
	
	

@Test
public void testCreateRegister() {
	
	
	Mockito.when(repo.save(register1)).thenReturn(registerID1); 
	
	boolean result = service.createRegister(register1);
	
	Assertions.assertTrue(result);
	
	Mockito.verify(repo, Mockito.times(1)).save(register1);
	

	
}


@Test
public void testGetById() {
	
	Long id = 1l; 
	Optional<PrisonRegister> op = Optional.of(registerID1);
	
	Mockito.when(this.repo.findById(id)).thenReturn(op);
	
	assertThat(this.service.getbyId(id)).isEqualTo(registerID1);
	
	Mockito.verify(repo, Mockito.times(1)).findById(id);
	
	
}

@Test
public void getRegister() {
	
List<PrisonRegister> allPrisoners = new ArrayList<>();

allPrisoners.add(register1);
	
Mockito.when(this.repo.findAll()).thenReturn(allPrisoners);
	
assertThat(this.service.getRegister()).isEqualTo(allPrisoners);
	
Mockito.verify(repo, Mockito.times(1)).findAll();
	
	

}

@Test
public void testUpdatePrisoner() {
	
	Long id = 1l; 
	
	PrisonRegister toUpdate = new PrisonRegister(1l, "test", "test", "test", "test", 1, 1, false, false, false);
	
	Optional<PrisonRegister> op = Optional.of(toUpdate);
	
	boolean isUpdated = true;
	
	PrisonRegister updated = new PrisonRegister(id, toUpdate.getprisonerName(), toUpdate.getCrime(), toUpdate.getReasonInSolitaryConfinement(), toUpdate.getWardRelocationOnceReleased(), toUpdate.getTotalPrisonSentenceInMonths(),toUpdate.getDaysinSolitaryConfinement(),toUpdate.isGangMember(), toUpdate.isSuicideWatch(), toUpdate.isRepeatVisitor());
	
	Mockito.when(this.repo.findById(id)).thenReturn(op);
	
	Mockito.when(this.repo.save(updated)).thenReturn(updated);
	
	assertThat(this.service.set(id, updated)).isEqualTo(isUpdated);
	
	Mockito.verify(repo, Mockito.times(1)).findById(id);
	
	Mockito.verify(repo, Mockito.times(1)).save(updated);


}

@Test
public void clear() {
	
	boolean deleted = true;
	
	assertThat(this.service.clear()).isEqualTo(deleted);
	
	Mockito.verify(repo, Mockito.times(1)).deleteAll();
	
}



@Test
public void remove() {
	
	Long id = 1l;
	
	boolean deleted = true;
	
	assertThat(this.service.remove(id)).isEqualTo(deleted);
	
	Mockito.verify(repo, Mockito.times(1)).deleteById(id);


}
}

