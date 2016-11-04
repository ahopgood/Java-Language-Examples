package com.alexander.java.examples.java7;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GenericDeclarations {

	//

	public static void main(String[] args){
		Map<String, String> java6Map = new HashMap<String, String>();
		java6Map.put("one", "First arg");
		java6Map.put("two", "Second arg");
		
		Map<String, String> java7Map = new HashMap<>();
		java7Map.put("one", "First arg");
		java7Map.put("two", "Second arg");

		//Try with abstract class
		List<Animal> animals = new LinkedList<>();
		animals.add(new Cat());

		Animal ani = (Animal)new Cat();
		animals.add(ani);
		for (Animal a : animals){
			System.out.println(a.noise());
		}

		//Try with interfaces
		List<Person> people = new LinkedList<>();
		people.add(new Developer());

		Person per = (Person)new Marketing();
		people.add(per);
		for (Person p : people){
			System.out.println(p.talk());
		}

	}

	public static abstract class Animal {
		public abstract String noise();
	}

	public static class Cat extends Animal{
		@Override
		public String noise() {
			return "Meow";
		}
	}

	public interface Person{
		public String talk();
	}

	public static class Developer implements Person {
		@Override
		public String talk() {
			return "Technology, technology, technology";
		}
	}

	public static class Marketing implements Person {
		@Override
		public String talk() {
			return "Features, features, features";
		}
	}
}
