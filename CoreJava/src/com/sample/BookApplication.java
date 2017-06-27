package com.sample;

import java.util.*;
/**
 * 
 * @author sangeetha
 *
 */
class Book {

	private String isbn, title, author, publisher;
	private int edition;
	private static int c = 0;
	private static Scanner input;

	public Book() {

		c++;
	}

	public static int getcnt() {

		return c;

	}

	public void get_details() {

		input = new Scanner(System.in);

		System.out.println("Enter title of the Book");
		title = input.next();

		System.out.println("Enter the ISBN NO of the Book");
		isbn = input.next();

		System.out.println("Enter the Author of the Book");
		author = input.next();

		System.out.println("Enter the Publisher of the Book");
		publisher = input.next();

		System.out.println("Enter edition number of the Book");
		edition = input.nextInt();
	}

	public void display_details() {
		System.out.println("THE DETAILS OF THE BOOK ARE");
		System.out.println("The Title : " + title);
		System.out.println("The Author : " + author);
		System.out.println("The ISBN Number : " + isbn);
		System.out.println("The Edition : " + edition);
		System.out.println("The Publisher : " + publisher);
	}

}

public class BookApplication {
	private static Scanner input;

	public static void main(String[] args) {
		Book[] arr = new Book[2];
		input = new Scanner(System.in);
		int choice1, i = 0, j;

		while (true) {
			System.out
					.println("Enter your choice to perform corresponding operation : ");
			System.out.println("1-Enter a new Object ");
			System.out.println("2-Display the Data of the Objects");
			System.out.println("3-Show total number of objects ");
			System.out.print("Enter your choice : \n\n");
			choice1 = input.nextInt();

			switch (choice1) {
			case 1:
				if (i < arr.length) {
					arr[i] = new Book();
					arr[i].get_details();
					i++;
				} else {
					System.out.println("You have reached Maximum limit!");
					System.out.println("You cannot Enter objects Anymore!");

				}
				break;

			case 2:
				for (j = 0; arr[j] != null; j++) {
					arr[j].display_details();
				}
				break;

			case 3:
				System.out.println("\nTotal number of objects : "
						+ Book.getcnt());
				break;

			}
			System.out.println("\n");
		}

	}
}