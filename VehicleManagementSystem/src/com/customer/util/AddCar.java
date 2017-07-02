package com.customer.util;

import java.util.Iterator;
import java.util.LinkedList;
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
public class AddCar implements Constants {

	Scanner obj;

	public void addNewCar(LinkedList<Customer> list) {
		obj = new Scanner(System.in);
		int typeOfCar, id;
		boolean found = false;
		try {
			Iterator<Customer> itr = list.iterator();
			Customer customerObj = null;

			if (itr.hasNext()) {
				System.out.println("Ids of Customers are : ");
				while (itr.hasNext()) {
					customerObj = (Customer) itr.next();
					System.out.println(customerObj.customerId + "-"
							+ customerObj.customerName + " ");
				}
				System.out.println("Choose the ID of customer : ");
				id = obj.nextInt();
				Iterator<Customer> itr2 = list.iterator();

				while (itr2.hasNext()) {
					customerObj = (Customer) itr2.next();
					if (id == customerObj.customerId) {
						found = true;
						break;
					}
				}
				if (found == false) {
					System.out.println("Id not found");
				} else {
					Car carObj = null;
					System.out.print("Enter type of car \n");
					System.out.print("1. Maruti \t2.Toyota \t3.Hyundai : ");
					typeOfCar = obj.nextInt();
					switch (typeOfCar) {
					case MARUTI:
						carObj = new Maruti();
						carObj.typeOfCar = Constants.CAR_TYPE_1;
						break;

					case TOYOTA:
						carObj = new Toyota();
						carObj.typeOfCar = Constants.CAR_TYPE_2;
						break;

					case HYUNDAI:
						carObj = new Hyundai();
						carObj.typeOfCar = Constants.CAR_TYPE_3;
						break;

					default:
						System.out.println("wrong choice");
						break;
					}
					obj.nextLine();
					carObj.carId = customerObj.carId++;
					System.out.print("Enter the Model of Car : ");
					carObj.setCarModel(obj.nextLine());
					System.out.print("Enter the Price of Car : ");
					carObj.setPrice(obj.nextFloat());
					carObj.setResaleValue();
					customerObj.cars.add(carObj);
				}
			} else {
				System.out.print("--------No Customer Found--------------");
			}
		} catch (Exception e) {
			System.out.println(e + " -- Exception Found");
		}
	}
}
