package com.sample;
/**
 * 
 * @author sangeetha
 *
 */
public class PrimeNumber {

	public static void main(String[] args) {
		int num = 17;
		int i;

		for (i = 2; i < num; i++) {
			int n = num % i;
			if (n == 0) {
				System.out.println(num + " is not Prime number!");
				break;
			}
		}
		if (i == num) {
			System.out.println(num + " is a Prime number!");
		}
	}
}
