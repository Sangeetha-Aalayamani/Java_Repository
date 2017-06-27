package com.sample.poly;
/**
 * 
 * @author Sangeetha
 *
 */
class Polygon {

	public void polygonSides(int x) {

		System.out.println("The number of sides in Polygon is : " + x);

	}

	public void polygonSides(int x, int y) {

		System.out.println("The Diagonal length is : " + x + " and " + y);

	}

}

public class Polymorphism {

	public static void main(String[] args) {

		Polygon polygon = new Polygon();

		// Here compiler decides that polygonSides(int) is to be called and
		// "int" will be printed.

		polygon.polygonSides(5);

		// Here compiler decides that polygonSides(int,int)is to be called and
		// "int and int" will be printed.
		polygon.polygonSides(2, 3);

	}
}
