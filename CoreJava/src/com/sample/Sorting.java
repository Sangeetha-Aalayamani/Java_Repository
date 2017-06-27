package com.sample;

import java.util.Arrays;

/**
 * 
 * @author sangeetha
 *
 */
public class Sorting {

	public static void main(String[] args) {

		int[] num = { 11, 20, 11, 2, 12, 100 };
		int l = num.length;
		int i;
		System.out.print("Entered elements are:: ");

		for (i = 0; i < l; i++) {
			System.out.print("  " + num[i]);
		}

		System.out.println("\n");
		System.out.print("Elements sorted in Ascending order : ");
		Arrays.sort(num);

		for (i = 0; i < l; i++) {
			System.out.print("  " + num[i]);
		}
	}

}
