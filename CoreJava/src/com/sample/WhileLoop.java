package com.sample;
/**
 * 
 * @author sangeetha
 *
 */
public class WhileLoop {

	public static void main(String[] args) {

		int a = 21, b = 1;
		
		System.out.println("the table of " + a + "is: ");
		System.out.println("Multiplication table");
		
		while (b <= 10) {
			int c = a * b;
			
			System.out.println(+a+" * " +b+"\t" +"="+c);
			b = b + 1;
		}
	}
}
