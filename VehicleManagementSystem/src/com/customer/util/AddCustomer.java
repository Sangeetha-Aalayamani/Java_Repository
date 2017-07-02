package com.customer.util;

import java.util.Scanner;

import com.customer.model.Car;
import com.customer.model.Customer;
import com.customer.model.Hyundai;
import com.customer.model.Maruti;
import com.customer.model.Toyota;
/**
 * 
 * @author sangeetha
 *
 */
public class AddCustomer implements Constants {
	
	private static Scanner input;
	public static int autoIncrementCustomerId = 1;

	public Customer addNewCustomer() {
		input = new Scanner(System.in);
		Customer customerObj = new Customer();
		int typeOfCar, choiceCar = 0;
		try {
			customerObj.setCustomerId(autoIncrementCustomerId++);
			System.out.print("Enter Customer Name : ");
			customerObj.setCustomerName(input.nextLine());

			customerObj.carId = 1;
			while (choiceCar == 0) {
				System.out.print("Enter type of car \n");
				System.out.print("1. Maruti \t2.Toyota \t3.Hyundai : ");
				typeOfCar = input.nextInt();
				
				Car carObj = null;
				
				switch (typeOfCar) {
							case MARUTI:
								carObj = new Maruti();
								carObj.typeOfCar = "Maruti";
								break;
			
							case TOYOTA:
								carObj = new Hyundai();
								carObj.typeOfCar = "Toyota";
								break;
			
							case HYUNDAI:
								carObj = new Toyota();
								carObj.typeOfCar = "Hyundai";
								break;
			
							default:
								System.out.println("wrong choice");
								break;
							}
							input.nextLine();
							carObj.carId = customerObj.carId++;
							System.out.print("Enter the Model of Car : ");
							carObj.setCarModel(input.nextLine());
							System.out.print("Enter the Price of Car : ");
							carObj.setPrice(input.nextFloat());
							carObj.setResaleValue();
							customerObj.cars.add(carObj);
							System.out.println("Want to enter more car ? (0-yes/1-no)");
							choiceCar = input.nextInt();
							input.nextLine();
			}
		} catch (Exception e) {
			System.out.println(e + " -------Exception Found ");
		}
		return customerObj;
	}
}
