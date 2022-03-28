package com.qa.prisonregister.controller.test.intergation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.prisonregister.prisonreg.PrisonRegister;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

@Sql(scripts = {"classpath:prisonreg.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("dev") 

public class ControllerTesting {
	
	
	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper; 
	
	PrisonRegister testRegisterwithID = new PrisonRegister (1l, "name","crime","reason","a", 1, 1, true, true, true);
	PrisonRegister testRegisterID = new PrisonRegister ("name","crime","reason","a", 1, 1, true, true, true);
	PrisonRegister testRegisterID2 = new PrisonRegister ("name","crime","reason","b", 2, 2, true, true, true);
	
	
	
	@Test
	public void testCreateRegister() throws Exception{
		
		PrisonRegister test = new PrisonRegister("test", "test", "test", "test", 1, 1, false, false, false);
		
		String bookingJson = mapper.writeValueAsString(test);
		
		RequestBuilder req = post("/createRegister").contentType(MediaType.APPLICATION_JSON).content(bookingJson);
		
		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().string("Prisoner added with ID: 3");
		mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	
	
		@Test
		public void testDeleteId() throws Exception {
			RequestBuilder req = delete("/delete/1"); 

			ResultMatcher checkStatus = status().isAccepted(); 
			ResultMatcher checkBody = content().string("Prisoner information with id 1 deleted"); 
															
			mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		}
		


		@Test
		public void testGetRegister() throws Exception {

			PrisonRegister testRegisterwithID1 = new PrisonRegister (1l, "name","crime","reason","a", 1, 1, true, true, true);
			PrisonRegister testRegisterwithID2 = new PrisonRegister (2l, "name","crime","reason","b", 2, 2, true, true, true);
			List<PrisonRegister> allRegister = List.of(testRegisterwithID1, testRegisterwithID2 ); 
			
																					
			String allRegisterJson = mapper.writeValueAsString(allRegister);

			RequestBuilder req = get("/getRegister");

			ResultMatcher checkStatus = status().isAccepted();
			ResultMatcher checkBody = content().json(allRegisterJson); 
							

			mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

		
	
		
		}

@Test
public void testGetId() throws Exception {



	String testRegisterIdJson = mapper.writeValueAsString(testRegisterwithID);

	
	RequestBuilder req = get("/getID/1");

	ResultMatcher checkStatus = status().isOk(); 
	ResultMatcher checkBody = content().json(testRegisterIdJson); 

	
	mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

}

@Test
public void testUpdate() throws Exception {

	
	PrisonRegister updatedRegister = new PrisonRegister("new name", "new crime", "new reason", "new ward", 10,10, false, false, false);

	
	String updatedRegisterJson = mapper.writeValueAsString(updatedRegister);

	
	RequestBuilder req = put("/update/1").contentType(MediaType.APPLICATION_JSON).content(updatedRegisterJson);

	ResultMatcher checkStatus = status().isOk();
	ResultMatcher checkBody = content().string("Prisoner 1 information updated.");

	mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

}

@Test 
public void testDeleteAll () throws Exception {
	
	RequestBuilder req = delete("/deleteAll");
	
	ResultMatcher checkStatus = status().isAccepted();
	ResultMatcher checkBody = content().string("All Prisoner information deleted. If this action was made in error or as a result of a cyber attack, remove portable harddrive, report to Cyber Unit");
		
	
	mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);

}
}











