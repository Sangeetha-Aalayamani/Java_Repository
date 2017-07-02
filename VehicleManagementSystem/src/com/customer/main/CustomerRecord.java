package com.customer.main;

import java.util.LinkedList;
import java.util.Scanner;

import com.customer.model.Customer;
import com.customer.util.AddCar;
import com.customer.util.AddCustomer;
import com.customer.util.Constants;
import com.customer.util.GeneratePrizes;
import com.customer.util.ListCustomer;
/**
 * 
 * @author sangeetha
 *
 */
public class CustomerRecord implements Constants {

	private static Scanner input;

	public static void main(String[] args) {
		
		input = new Scanner(System.in);
		LinkedList<Customer> customerList = new LinkedList<Customer>();
		int choice, continueVar = 0;

		try {
			while (continueVar == 0) {
				
				System.out.println(" ENTER YOUR CHOICE: ");
				System.out.println("1. Add new customer");
				System.out.println("2. Add new car to existing customer");
				System.out.println("3. List all customers with details sorted by car model name ");
				System.out.println("4. List individual customer");
				System.out.println("5. Generate Prizes");
				System.out.println("6. Exit ");
				choice = input.nextInt();
				
				switch (choice) {
				case ADD_CUSTOMER:
					AddCustomer addCustomerObj = new AddCustomer();
					customerList.add(addCustomerObj.addNewCustomer());
					break;

				case ADD_CAR:
					AddCar addCarObj = new AddCar();
					addCarObj.addNewCar(customerList);
					break;

				case LIST_ALL_CUSTOMERS:
					ListCustomer listObj = new ListCustomer();
					listObj.listAllCustomers(customerList);
					break;

				case LIST_CUSTOMER:
					ListCustomer listOneObj = new ListCustomer();
					listOneObj.listOneCustomer(customerList);
					break;

				case GENERATE_PRIZE:
					GeneratePrizes generatePrizeObj = new GeneratePrizes();
					generatePrizeObj.generatePrizes(customerList);
					break;

				case EXIT:
					System.exit(0);
					break;

				default:
					System.out.println("wrong choice");
				}
				System.out.print("\nDo you wish to continue ? (0-yes/1-no) : ");
				continueVar = input.nextInt();
			}
		} catch (Exception e) {
			System.out.print(e + " - Exception Found \n");
		}
	}
}
