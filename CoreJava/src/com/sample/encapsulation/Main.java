package com.sample.encapsulation;

public class Main {

	public static void main(String[] args) {

		Encapsulation example = new Encapsulation();
		example.setRoll(111);
		example.setName("J Kumar");
		System.out.println("Roll No : " + example.getRoll());
		System.out.println("Name : " + example.getName());
		System.out.println("Grade : " + example.findGrade());

	}
}
