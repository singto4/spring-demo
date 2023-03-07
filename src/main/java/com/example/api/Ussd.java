package com.example.api;

import org.apache.commons.lang3.RandomStringUtils;

public class Ussd {
	
	public static void main(String[] args) {
		
		String c = RandomStringUtils.randomAlphabetic(5).toUpperCase();
        System.out.println(c);
        c = RandomStringUtils.randomAlphabetic(5).toUpperCase();
        System.out.println(c);
        
        String referenceIdWs = String.format("EP%s%s%s",
                "ssss",
                "aaaa", RandomStringUtils.randomAlphabetic(5).toUpperCase());
        
        System.out.println(referenceIdWs);
	}

}
