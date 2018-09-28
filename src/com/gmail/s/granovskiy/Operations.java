package com.gmail.s.granovskiy;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Operations {
	
	private String[] arrayOne;
	
	//    constructors
	public Operations(String[] arrayOne) {
		super();
		this.arrayOne = arrayOne;
	}
	public Operations() {
		super();
	}
	
    //    getter and setter
	public String[] getArrayOne() {
		return arrayOne;
	}
	public void setArrayOne(String[] arrayOne) {
		this.arrayOne = arrayOne;
	}
	
	//  method getLinks
	public String[] getLinks() {
		File file = new File("test.txt");
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String text = "";
			for (; (text = br.readLine()) != null;) {
				sb.append(text).append(System.lineSeparator());
				arrayOne = sb.toString().split(System.lineSeparator());
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		return arrayOne;
	}
    
	//  method getResponse
	public void getResponse(String[] array) {
		for (String string : array) {	
			try {
				URL url = new URL(string);   //  creating new object   
				HttpURLConnection urlc = (HttpURLConnection) url.openConnection();  //  creating HttpURLConnection
				System.out.println("Method of request to server: " + urlc.getRequestMethod());
				System.out.println("Type of response: " + urlc.getResponseMessage());
				System.out.println(urlc.getHeaderField(0));

			} catch (Exception e) {
				System.out.println(e.toString());
			}
		}
	}
}
