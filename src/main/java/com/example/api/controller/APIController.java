package com.example.api.controller;

import java.io.File;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIController {

	@GetMapping(value = "/api1")
	public String getData1() {
		return "Data 1";
	}
	
	@GetMapping(value = "/api2")
	public String getData2() {
		return "Data 2";
	}
	
	@GetMapping(value = "/getFileName")
	public String getFileName() {
		
		StringBuilder str = new StringBuilder();
		String path = "Nas/";
		File file = new File(path);
		File[] files = file.listFiles();
		for (File obj : files) {
			str.append(obj.getName() + ", ");
		}
		return str.toString();
	}
}
