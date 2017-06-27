/**
 * A Credit card company allows a limit to spend 15000 to its clients. 
 * It also offers a cash back facility according the table shown below. 
 * Input the amount spent by the use and display the cash back amount he is entitled to. 
 * Use minimum number of conditions to solve the problem.
 *  Amount (in ) Cash Back (in) First 1000 100 Next 2000 200
 *   + 2% of amount exceeding 1000 Next 4000 400
 *   + 4% of amount exceeding 3000 Next 8000 800 
 *   + 8% of amount exceeding 7000
 */
package com.sample.control;

import java.util.Scanner;

public class ControlStatements {

	private static Scanner input;

	public static void main(String... args) {

		input = new Scanner(System.in);
		double amount, cashback = 0;

		System.out.print("Enter the Amount:");
		amount = input.nextDouble();

		if (amount <= 1000) {
			cashback = 100;
		} else if (amount <= 3000) {
			cashback = 200 + (amount - 1000) * .02;
		} else if (amount <= 7000) {
			cashback = 400 + (amount - 3000) * .04;
		} else if (amount <= 15000) {
			cashback = 800 + (amount - 7000) * .08;
		}
		System.out.print("Cash Back= " + cashback);
	}
}
