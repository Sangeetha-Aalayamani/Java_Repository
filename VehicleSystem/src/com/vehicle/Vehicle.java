
package com.vehicle;

import java.util.Scanner;
/**
 * 
 * @author sangeetha
 *
 */
public abstract class Vehicle  {
    
    String colour,price,type,company,subtype;
    int qty, capacity;
    float topSpeed,weight;
    
    Scanner input = new Scanner(System.in);
    Engine engine;
    
    Vehicle()
    {
		float size = 1;
        engine= new Engine(size);
    }
    
    Vehicle(float size)
    {
    	engine= new Engine(size);
    }
    
    public void getCarInfo()
    {
		System.out.println("Please enter the company");
		company = input.next();
		
		System.out.println("Please enter the price of the vehicle(in rupees)");
		price = input.next();
		
		System.out.println("Please enter the quantity of the vehicle");
		qty = input.nextInt();
		
		System.out.println("Please enter the weight of the vehicle(in Kg)");
		weight = input.nextFloat();
		
		System.out.println("Please enter the topspeed of the vehicle(in Km/hr)");
		topSpeed = input.nextFloat();
		
		System.out.println("Please enter the colour of the object");
		colour = input.next();
		
		System.out.println("Please enter the capacity(how many persons) of the vehicle");
		capacity = input.nextInt();
               
    }
    public void displayInfo()
    {
    	System.out.println("***************CAR DETAILS*************");
		System.out.println("Company: " + company);
		System.out.println("Price: " + price + " Rs");
		System.out.println("Quantity: " + qty);
		System.out.println("Engine size: " + engine.size + "  litre");
		System.out.println("Colour: " + colour);
		System.out.println("Weight: " + weight + " kg");
		System.out.println("Top Speed: " + topSpeed + "km/hr");
		System.out.println("Capacity: " + capacity + "persons");
        
    }
}