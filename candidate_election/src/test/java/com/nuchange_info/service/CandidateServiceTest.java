package com.nuchange_info.service;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;

import com.nuchange_info.model.Candidate;

@TestMethodOrder(OrderAnnotation.class)
class CandidateServiceTest {
	
	private CandidateService service = new CandidateService();

	@Test
	@Order(1)
	void testCreateCandidate() throws Exception {
		Candidate expect = new Candidate("pavan", (long) 0);
		Candidate candidate = service.createCandidate("pavan");
		assertThat(expect).isEqualTo(candidate);	
	}

	@Test
	@Order(2)
	void testAddVote() throws Exception {
		Candidate expect = new Candidate("pavan",(long) 1);
		Candidate candidate = service.addVote("pavan");
		assertThat(expect).isEqualTo(candidate);
	}

	@Test
	@Order(3)
	void testGetCountOfVote() throws Exception {
		Candidate expect = new Candidate("pavan", (long) 1);
		Candidate candidate = service.addVote("pavan");
		assertThat(expect).isEqualTo(candidate);
	}

	@Test
	@Order(4)
	void testGetAllNamesAndVotes() throws Exception {
		Map<String, Long> expect = new HashMap<>();
		expect.put("pavan", (long) 1);
		Map<String, Long> actual = service.getAllNamesAndVotes();
		assertThat(expect).isEqualTo(actual);
	}

	@Test
	@Order(5)
	void testGetWinner() throws Exception {
		Map<String, Long> expect = new HashMap<>();
		expect.put("pavan", (long) 1);
		Map<String, Long> actual = service.getWinner();
		assertThat(expect).isEqualTo(actual);
	}

}
