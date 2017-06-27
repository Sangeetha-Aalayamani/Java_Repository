package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * 
 * @author sangeetha
 *
 */
public class AreaCircle {

	public static void main(String[] args) {

		int r = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the radius of circle:");

		try {
			r = Integer.parseInt(br.readLine());
			double area = java.lang.Math.PI * r * r;
			System.out.println("Area of Circle : " + area);
			double perimeter = 2 * java.lang.Math.PI * r;
			System.out.println("Perimeter of Circle : " + perimeter);

		} catch (NumberFormatException nfe) {
			// TODO Auto-generated catch block
			nfe.printStackTrace();
		} catch (IOException ioe) {
			// TODO Auto-generated catch block
			ioe.printStackTrace();
		}

	}
}
