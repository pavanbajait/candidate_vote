package com.nuchange_info.validator;

import org.springframework.stereotype.Service;

@Service
public class CandidateValidator {
	
	public static boolean isNullOrEmpty(String string) {
	    if (string == null || string.isEmpty()) {
	      return true;
	    }
	    return false;
	  }

}
