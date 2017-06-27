package com.sample;

import java.util.Scanner;

/**
 * 
 * @author sangeetha
 *
 */
public class Factorial {

	private static Scanner input;

	public static void main(String[] args) {

		input = new Scanner(System.in);
		System.out.println("enter the number");
		int number = input.nextInt();
		double fact = 1;
		System.out.println("Factorial of " + number + ":");
		for (int i = 1; i <= number; i++) {
			fact = fact * i;
		}
		System.out.println(fact);
	}

}
