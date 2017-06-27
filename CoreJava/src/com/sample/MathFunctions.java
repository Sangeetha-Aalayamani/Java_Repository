package com.sample;
/**
 * 
 * @author sangeetha
 *
 */
public class MathFunctions {

	public static void main(String[] args) {
		
		// Use of mathematical functions
		
		// Exponent and round()
		System.out.println("e = " + Math.round(Math.E * 100) / 100f);
		// PI
		System.out.println("pi = " + Math.round(Math.PI * 100) / 100f);
		// abs()
		System.out.println("Absolute number = " + Math.abs(Math.PI));
		// ceil()
		System.out.println("Smallest value but greater than the argument = "+ Math.ceil(Math.PI));
		// exp()
		System.out.println("Exponent number powered by the argument = "+ Math.exp(0));
		// floor()
		System.out.println("Largest value but less than the argument = "+ Math.floor(Math.E));
		// IEEEremainder()
		System.out.println("Remainder = " + Math.IEEEremainder(5.3f, 2.2f));
		// max()
		System.out.println("Maximum Number = " + Math.max(10, 10.3));
		// min()
		System.out.println("Minimum Number = " + Math.min(10, 10.3));
		// pow()
		System.out.println("Power = " + Math.pow(10, 3));
		// random()
		System.out.println("Random Number = " + Math.random());
		// rint()
		System.out.println("Closest to the Argument = " + Math.rint(30));
		// round()
		System.out.println("Round = " + Math.round(Math.E));
		// sqrt()
		System.out.println("Square Root = " + Math.sqrt(400));
	}
}
