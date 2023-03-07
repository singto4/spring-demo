package com.example.api;

import java.util.ArrayList;
import java.util.List;

public class App9 {
	
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list = null;
		
		for(String str : list) {
			System.out.println(str);
		}
	}

}
