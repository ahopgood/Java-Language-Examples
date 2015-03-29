package com.alexander.java.examples.java7;

import java.util.HashMap;
import java.util.Map;

public class GenericDeclarations {

	public static void main(String[] args){
		Map<String, String> java6Map = new HashMap<String, String>();
		java6Map.put("one", "First arg");
		java6Map.put("two", "Second arg");
		
		Map<String, String> java7Map = new HashMap<>();
		java7Map.put("one", "First arg");
		java7Map.put("two", "Second arg");
	}
}
