package com.nuchange_info;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.nuchange_info.model.Candidate;

@SpringBootApplication
public class CandidateElectionApplication {

//	private static List<Candidate> listCandidate;
	
	public static void main(String[] args) {
		SpringApplication.run(CandidateElectionApplication.class, args);
	}
	
//	@Bean
//	public List<Candidate> getAll(){
//		return this.listCandidate;
//	}

}
