package com.sample;

public class Matrix {

	public static void main(String[] args) {

		int array[][] = { { 4, 5, 6 }, { 6, 8, 9 } };
		int array1[][] = { { 5, 4, 6 }, { 5, 6, 7 } };
		System.out.println("Number of Row= " + array.length);
		System.out.println("Number of Column= " + array[1].length);
		int l = array.length;
		System.out.println("Matrix 1 : ");
		for (int i = 0; i < l; i++) {
			for (int j = 0; j <= l; j++) {
				System.out.print(" " + array[i][j]);
			}
			System.out.println();
		}
		int m = array1.length;
		System.out.println("Matrix 2 : ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= m; j++) {
				System.out.print(" " + array1[i][j]);
			}
			System.out.println();
		}
		System.out.println("Addition of both matrix : ");
		for (int i = 0; i < m; i++) {
			for (int j = 0; j <= m; j++) {
				System.out.print(" " + (array[i][j] + array1[i][j]));
			}
			System.out.println();
		}
	}
}
