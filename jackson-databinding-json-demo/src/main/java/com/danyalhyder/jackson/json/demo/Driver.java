package com.danyalhyder.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public Driver() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		try {
			
			//Create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			//read json file and map/convert to Java POJO: 
			//data/sample-lite.json
			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print first name and last name from json
			System.out.println("First Name = " + theStudent.getFirstName());
			System.out.println("Last Name = " + theStudent.getLastName());
			
			//print out address : street and city
			Address tempAddress = theStudent.getAddress();
			System.out.println("Street:" +tempAddress.getStreet());
			System.out.println("City:" +tempAddress.getCity());
			
			//Print out languages
			for (String tempLang : theStudent.getLanguages()) {
				System.out.println(tempLang);
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}

}
