package com.example.api;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Locale;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

public class App {

	public static void main(String[] args) {

//		Obj obj1 = new Obj();
//		obj1.setName("AAA");
//		Obj obj2 = new Obj();
//		obj2.setSex("F");
//		obj2.setOld("18");
//		
//		BeanWrapper src = new BeanWrapperImpl(obj1);
//		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
//		Set emptyNames = new HashSet();
//		for(java.beans.PropertyDescriptor pd : pds) {
//			//check if value of this property is null then add it to the collection
//			Object srcValue = src.getPropertyValue(pd.getName());
//			if (srcValue == null) {// Filter specific characters written here , Collection not required copy A list of fields for . Filter here null For example
//			emptyNames.add(pd.getName());
//			}
//		}
//		
//		String[] result = new String[emptyNames.size()];
//        String[] data = (String[]) emptyNames.toArray(result);
//		
//		BeanUtils.copyProperties(obj1, obj2, data);
//		System.out.println(obj2.toString());
		
//		Obj obj1 = new Obj();
//		obj1.setName("XXXX");
//		obj1.setOld("0");
//		
//		Obj2 obj2 = new Obj2();
//
//		BeanUtils.copyProperties(obj1, obj2);
//		System.out.println(obj2.toString());
		
//		String target = "Micro Computer";
//		String mask = "C Programming";
		
		String target = "SCAAT.th.edu";
		String mask = "IT Exhibition";
		
		// check length
		int loop = target.length();
		if (loop > mask.length()) {
			for (int i = mask.length(); i<loop; i++) {
				mask += " ";
			}
		} else {
			for (int i = loop; i<mask.length(); i++) {
				target += " ";
			}
		}

		char[] targetArray = target.toCharArray();
		char[] maskArray = mask.toCharArray();
		
		String result = "";
		for (int i = 0; i<loop; i++ ) {
			String targetWord = String.valueOf(targetArray[i]);
			String maskWord = String.valueOf(maskArray[i]);
			if (targetWord.matches("[A-Z]") && maskWord.matches("[A-Z]")) {
				result += targetWord;
			} else if (targetWord.matches("[a-z]") && maskWord.matches("[a-z]")) {
				result += maskWord;
			} else if ((targetWord.matches("[A-Za-z]") && maskWord.matches("[A-Za-z]")) && targetWord != maskWord) {
				result += "$";
			} else {
				result += "#";
			}
		}
		
		System.out.println(result);
		
	}
	

}

class Obj2 {
	
	@JsonProperty("name_d")
	String name;
	String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "Obj [name=" + name + ", sex=" + sex 
				+"]";
	}
	
}




class Obj {
	
	String name;
	String sex;
	String old;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getOld() {
		return old;
	}
	public void setOld(String old) {
		this.old = old;
	}
	@Override
	public String toString() {
		return "Obj [name=" + name + ", sex=" + sex + ", old=" + old + "]";
	}

}
	
	