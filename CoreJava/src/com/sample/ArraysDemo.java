package com.sample;

import static java.lang.Math.pow;
import java.util.*;

class ArrayExampleList {

	private int[] array;
	private int size;
	private Scanner in;

	ArrayExampleList(int i) {
		size = i;
		array = new int[size];
	}

	public void addnumbers() {
		in = new Scanner(System.in);
		int i;

		for (i = 0; i < array.length; i++) {
			System.out.println("\nEnter value no." + (i + 1) + ": ");
			array[i] = in.nextInt();
		}

	}

	public void displaynumbers() {
		int i;
		System.out.print("\n(");
		for (i = 0; i < array.length; i++) {
			if (i < array.length - 1)
				System.out.print("" + array[i] + ", ");

			else
				System.out.print("" + array[i] + ")\n");

		}
	}

	public void deleteitem() {

		in = new Scanner(System.in);
		int delete, i, cnt = 0;
		System.out.println("\n\nEnter the value to delete: ");
		delete = in.nextInt();

		for (i = 0; i < array.length; i++) {
			if (array[i] == delete) {
				array[i] = 0;
			}

			else
				cnt++;

		}

		if (cnt == array.length)
			System.out
					.println("The value is not found in the array! Enter again.");

		else {
			System.out.println("\nNumber deleted successfully!");
			for (i = 0; array[i] != 0; i++)
				;

			for (; i < array.length - 1; i++) {
				array[i] = array[i + 1];
				array[i + 1] = 0;
			}

		}

	}

	public void duplicate() {
		int i, j;
		int cnt = 0;

		int[] copyarray = new int[array.length];

		for (i = 0; i < array.length; i++) {
			copyarray[i] = array[i];
		}

		for (i = 0; i < array.length; i++) {
			cnt = 1;
			for (j = i + 1; j < array.length; j++) {
				if (copyarray[i] == copyarray[j]) {
					cnt++;
					copyarray[j] = 0;

				}

			}

			if (copyarray[i] != 0)
				System.out.println("The number " + copyarray[i] + " occurs "
						+ cnt + " times.");

		}
	}

	public void deleteduplicate() {
		int i, j;
		int cnt = 0;

		for (i = 0; i < array.length; i++) {
			cnt = 1;
			for (j = i + 1; j < array.length; j++) {
				if (array[i] == array[j]) {
					cnt++;
					array[j] = 0;

				}

			}

			if (array[i] != 0)
				System.out.println("The number " + array[i] + " occurs " + cnt
						+ " times.");

		}

		for (i = 0; array[i] != 0; i++)
			;

		for (; i < array.length - 1; i++) {
			array[i] = array[i + 1];
			array[i + 1] = 0;
		}

	}

	public void sort(int sortchoice) {
		int i, j, temp;
		if (sortchoice == 1) {
			for (i = 0; i < array.length; i++) {
				for (j = i + 1; j < array.length; j++) {
					if (array[i] > array[j]) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}

		else if (sortchoice == 2) {
			for (i = 0; i < array.length; i++) {
				for (j = i + 1; j < array.length; j++) {
					if (array[i] < array[j]) {
						temp = array[i];
						array[i] = array[j];
						array[j] = temp;
					}
				}
			}
		}

		else
			System.out.println("Enter valid choice!");

	}

	public void reverse() {
		int i, temp;

		for (i = 0; i < (array.length / 2); i++) {
			temp = array[i];
			array[i] = array[array.length - 1 - i];
			array[array.length - 1 - i] = temp;
		}
	}

	public void statistics() {
		int max, min, temp1, temp2;
		float mean = 0, median = 0, mode = 0, sum = 0, stddev = 0;
		int i;
		max = array[array.length - 1];
		min = array[0];

		System.out.println("The maximum value in the array is: " + max);
		System.out.println("The minimum value in the array is: " + min);

		for (i = 0; i < array.length; i++) {
			sum += array[i];
		}

		System.out.println("The sum of values of the array is: " + sum);

		mean = sum / array.length;
		System.out.println("The mean of values of the array is: " + mean);

		// Calculating MEDIAN
		if (array.length % 2 != 0) {
			median = array[(array.length / 2)];
		}

		else {
			median = array[(array.length / 2) - 1];
		}

		System.out.println("The median of the values of the array is: "
				+ median);

		mode = array[0]; // Calculating MODE.
		temp1 = 1;
		temp2 = 1;
		for (i = 1; i < array.length; i++) {
			if (array[i - 1] == array[i]) {
				temp1++;
			} else {
				temp1 = 1;
			}
			if (temp1 >= temp2) {
				mode = array[i];
				temp2 = temp1;
			}
		}

		if (temp1 == 1 && temp2 == 1) {
			System.out.println("There is no mode!");
		}

		else {
			System.out.println("The mode is: " + mode);
		}

		sum = 0;
		for (i = 0; i < array.length; i++) {
			sum += pow(((array[i]) - mean), 2) / array.length;

		}
		stddev = (float) pow(sum, 0.5); // /Calculating STANDARD DEVIATION.
		System.out.println("The standard deviation is: " + stddev);
	}

}

public class ArraysDemo {

	private static Scanner in;

	public static void main(String[] args) {
		in = new Scanner(System.in);

		int i, ch, sortchoice;
		System.out.println("Enter the size of the array: ");
		i = in.nextInt();
		ArrayExampleList numbers = new ArrayExampleList(i);

		while (true) {
			System.out.println("\n1. Enter values.");
			System.out.println("2. View the array.");
			System.out.println("3. Delete a number from the array.");
			System.out.println("4. Find duplicate values in array.");
			System.out.println("5. Delete duplicate entries.");
			System.out.println("6. Sort the array.");
			System.out.println("7. Reverse the list.");
			System.out.println("8. Display statistics about the array.");
			System.out.println("0. Exit.");
			System.out.println("Enter your choice: ");
			ch = in.nextInt();

			switch (ch) {
			case 1: {
				numbers.addnumbers();
			}

				break;

			case 2: {
				System.out.print("\nThe array entered is: \n");
				numbers.displaynumbers();
			}

				break;

			case 3: {
				System.out.print("\nThe array is: \n");
				numbers.displaynumbers();
				numbers.deleteitem();
				System.out.print("\nThe new array is: \n");
				numbers.displaynumbers();
			}
				break;

			case 4: {
				System.out.println("The entered array is: ");
				numbers.displaynumbers();
				numbers.duplicate();
			}

				break;

			case 5: {
				numbers.deleteduplicate();
				System.out.println("\nThe array is: \n");
				numbers.displaynumbers();

			}

				break;

			case 6: {
				System.out
						.println("Sort by? (1 - Ascending; 2 - Descending): ");
				sortchoice = in.nextInt();

				numbers.sort(sortchoice);
				System.out.println("The sorted array is: ");
				numbers.displaynumbers();
			}
				break;

			case 7: {
				numbers.reverse();
				System.out.println("The reverse list is: ");
				numbers.displaynumbers();
			}

				break;

			case 8: {
				numbers.sort(1);
				numbers.statistics();
			}

				break;

			case 0:
				return;

			}
		}

	}

}
