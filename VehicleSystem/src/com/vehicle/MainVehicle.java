package com.vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 
 * @author sangeetha
 *
 */
public class MainVehicle {
	
	private static Scanner in;

	public static void main(String[] args) {
		
		int chooseOption;
		List<Vehicle> Vehicle = new ArrayList<Vehicle>();

		while (true) {
			
			System.out.println("******Vehicle Information Systems******");
			System.out.println("***************************************");
			System.out.println("1. Add a vehicle");
			System.out.println("2. Display the list of vehicles");
			System.out.println("3. Update the vehicle information");
			System.out.println("4. Delete a vehicle");
			System.out.println("5. Exit");
			System.out.println("\n Please enter your choice");
			
			in = new Scanner(System.in);
			chooseOption = in.nextInt();

			switch (chooseOption) {
			case 1:
				System.out.println("Which type of vehicle you would like to add?");
				System.out.println("1. Two wheeler");
				System.out.println("2. Four wheeler");
				System.out.println("\nPlease enter a choice");
				chooseOption = in.nextInt();

				if (chooseOption == 1) {
					Vehicle v;
					System.out.println("Please enter the size of the engine(in Litres)");
					float size = in.nextFloat();
					v = new TwoWheeler(size);
					v.type = "Two Wheeler";
					v.getCarInfo();
					Vehicle.add(v);
					System.out.println("Vehicle information added successfully");
				}
				if (chooseOption == 2) {
					FourWheeler v;
					System.out.println("Which type of Four Wheeler you would like to add?");
					System.out.println("1. Private car");
					System.out.println("2. Commercial car");
					System.out.println("\nPlease enter a choice");
					chooseOption = in.nextInt();

					if (chooseOption == 1) {
						System.out
								.println("Please enter the size of the engine(in Litres)");
						float size = in.nextFloat();
						v = new PrivateCar(size);
						v.type = "Four Wheeler";
						v.subtype = "Private Car";
						v.getCarInfo();
						Vehicle.add(v);
						System.out.println("Vehicle information added successfully");
					}
					if (chooseOption == 2) {
						System.out
								.println("Please enter the size of the engine(in Litres)");
						float size = in.nextFloat();
						v = new CommercialCar(size);
						v.type = "Four Wheeler";
						v.subtype = "Commercial Car";
						v.getCarInfo();
						Vehicle.add(v);
						System.out.println("Vehicle information added successfully");
					}
				}
				break;
			case 2:
				if (Vehicle.isEmpty() == true)
					System.out.println("The list is empty");
				else {
					for (int i = 0; i < Vehicle.size(); i++) {
						System.out.println("Position: " + i);
						System.out.println("Type: " + Vehicle.get(i).type);
						System.out.println("SubType: " + Vehicle.get(i).subtype);
						Vehicle.get(i).displayInfo();
						System.out.println("\n");

					}
				}
				break;
			case 3:
				if (Vehicle.isEmpty() == true)
					System.out.println("The list is empty");
				else {
					for (int i = 0; i < Vehicle.size(); i++) {
						System.out.println("Position: " + i);
						System.out.println("Type: " + Vehicle.get(i).type);
						System.out.println("SubType: " + Vehicle.get(i).subtype);
						Vehicle.get(i).displayInfo();
						System.out.println("\n\n");

					}
					System.out.println("Please enter the position of the object you would like to update");
					int pos = in.nextInt();
					Vehicle.get(pos).getCarInfo();
					System.out.println("Vehicle Information updated successfully");
				}
				break;
			case 4:
				if (Vehicle.isEmpty() == true) {
					System.out.println("The list is empty");
				} else {
					for (int i = 0; i < Vehicle.size(); i++) {
						System.out.println("Position: " + i);
						System.out.println("Type: " + Vehicle.get(i).type);
						System.out.println("SubType: " + Vehicle.get(i).subtype);
						Vehicle.get(i).displayInfo();
						System.out.println("\n\n");

					}
					System.out.println("Please enter the position of the object you would like to delete");
					int pos = in.nextInt();
					Vehicle.remove(pos);
					System.out.println("Object successfully removed");
				}
				break;
			case 5:
				System.exit(0);
				return;
			}
		}

	}
}