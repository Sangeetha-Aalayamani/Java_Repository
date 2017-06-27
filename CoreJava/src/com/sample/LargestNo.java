package com.sample;
/**
 * 
 * @author sangeetha
 *
 */
public class LargestNo {
	public static void main(String[] args) {
		int x = 1000, y = 700, z = 5000;
		if (x > y) {
			if (x > z) {
				System.out.println("x is greater");
			} else {
				if (z > y) {
					System.out.println("z is greater");
				} else {
					System.out.println("y is greater");
				}
			}
		} else {
			if (y > z) {
				System.out.println("y is greater");
			}
		}
	}
}