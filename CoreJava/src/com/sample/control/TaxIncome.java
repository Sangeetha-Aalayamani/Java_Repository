package com.sample.control;

import java.util.Scanner;
/**
 * 
 * @author sangeetha
 *
 */
public class TaxIncome {
	
	private static Scanner input;
	
	public static void main(String[] args) {

		input = new Scanner(System.in);
		double taxincome, tax = 0;
		System.out.print("Enter Tax Income = ");
		taxincome = input.nextDouble();

		if (taxincome <= 100000)
			tax = 0;
		else if (taxincome <= 150000)
			tax = ((taxincome - 100000) * 10) / 100;
		else if (taxincome <= 250000)
			tax = 5000 + (((taxincome - 150000) * 20) / 100);
		else
			tax = 25000 + (((taxincome - 250000) * 30) / 100);

		System.out.print("Tax= " + tax);
	} 
} 