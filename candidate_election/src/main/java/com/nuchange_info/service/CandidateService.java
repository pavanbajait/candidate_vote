package com.nuchange_info.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.nuchange_info.model.Candidate;
import com.nuchange_info.validator.CandidateValidator;

@Service
public class CandidateService {
	
	private static List<Candidate> listCandidate = new ArrayList<>();
	
	@Autowired
	private CandidateValidator validator;
	
	@Async("asyncExecutor")
	public Candidate createCandidate(String name) throws Exception {
		if(validator.isNullOrEmpty(name)) 
			throw new Exception("Name can not be Null Or Empty!");
		Candidate candidate = new Candidate();
		candidate.setCandidateName(name);
		Long vote = (long) 0;
		candidate.setVoteCount(vote);
		if(listCandidate.contains(candidate)) {
			throw new Exception("Candidate already present with enetered name...");
		}
		listCandidate.add(candidate);
		return candidate;
	}

	@Async("asyncExecutor")
	public Candidate addVote(String name) throws Exception {
		if(validator.isNullOrEmpty(name)) 
			throw new Exception("Name can not be Null Or Empty!");
		
		boolean flag = false;
		for(Candidate eachCandidate : listCandidate) {
			if(eachCandidate.getCandidateName().equals(name)) {
				Long newVoteCount = eachCandidate.getVoteCount()+1;
				eachCandidate.setVoteCount(newVoteCount);
				return eachCandidate;
			}
		}
		if(!flag) 
			throw new Exception("Candidate Not Found, Please add candidate first...");
		
		return null;
	}

	@Async("asyncExecutor")
	public Candidate getCountOfVote(String name) throws Exception {
		if(validator.isNullOrEmpty(name)) 
			throw new Exception("Name can not be Null Or Empty!");
		
		if(listCandidate.size() <= 0) 
			throw new Exception("Please add candidate first...");
		
		boolean flag = false;
		for(Candidate eachCandidate : listCandidate) {
			if(eachCandidate.getCandidateName().equals(name)) {
				return eachCandidate;
			}
		}
		if(!flag) 
			throw new Exception("Candidate Not Found, Please add candidate first...");
		
		return null;
	}

	@Async("asyncExecutor")
	public Map<String, Long> getAllNamesAndVotes() throws Exception {
		if(listCandidate.size() <= 0) 
			throw new Exception("Please add candidate first...");
		
		Map<String, Long> hashmap = new HashMap<>();
		for(Candidate eachCandidate : listCandidate) {
			hashmap.put(eachCandidate.getCandidateName(), eachCandidate.getVoteCount());
		}
		return hashmap;
	}

	@Async("asyncExecutor")
	public Map<String, Long> getWinner() throws Exception {
		if(listCandidate.size() <= 0) {
			throw new Exception("Please add candidate first...");
		}
		Map<String, Long> hashmap = new HashMap<>();
		Long maxVote=(long) 0;
		for(Candidate eachCandidate : listCandidate) {
			if(eachCandidate.getVoteCount() > maxVote) {
				if(hashmap.size()!=0) {
					hashmap.clear();
				}
				hashmap.put(eachCandidate.getCandidateName(), eachCandidate.getVoteCount());
				maxVote = eachCandidate.getVoteCount();
			}
			else if(eachCandidate.getVoteCount() == maxVote) {
				hashmap.put(eachCandidate.getCandidateName(), eachCandidate.getVoteCount());
			}
		}
		if(hashmap.size() > 1) 
			throw new Exception("ELection winner results tie between candidates : "+hashmap.toString());
		return hashmap;
	}
	
	

}
