package com.nuchange_info.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuchange_info.model.Candidate;
import com.nuchange_info.service.CandidateService;

@RestController
public class ElectionController {
	
	@Autowired
	private CandidateService candidateService;

	@PostMapping(value = "/entercandidate")
	public ResponseEntity<?> saveCandidate(@RequestParam(required = false) String name) throws Exception {
		Candidate candidate = candidateService.createCandidate(name);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/castvote")
	public ResponseEntity<?> castVote(@RequestParam(required = false) String name) throws Exception {
		Candidate candidate = candidateService.addVote(name);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
	}
	
	@GetMapping(value = "/countvote")
	public ResponseEntity<?> getCountOfVote(@RequestParam(required = false) String name) throws Exception {
		Candidate candidate = candidateService.getCountOfVote(name);
		return new ResponseEntity<Candidate>(candidate,HttpStatus.OK);
	}
	
	@GetMapping(value = "/listvote")
	public ResponseEntity<?> getAllNamesAndVotes( ) throws Exception {
		Map<String, Long> namesVotes = candidateService.getAllNamesAndVotes();
		return new ResponseEntity<Map<String, Long>>(namesVotes,HttpStatus.OK);
	}
	
	@GetMapping(value = "/getwinner")
	public ResponseEntity<?> getWinner( ) throws Exception {
		Map<String, Long> namesVotes = candidateService.getWinner();
		return new ResponseEntity<Map<String, Long>>(namesVotes,HttpStatus.OK);
	}
	
}
