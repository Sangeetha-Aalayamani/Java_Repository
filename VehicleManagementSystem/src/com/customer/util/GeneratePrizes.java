package com.customer.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

import com.customer.model.Customer;
/**
 * 
 * @author sangeetha
 *
 */
public class GeneratePrizes {
	Scanner input;

	public void generatePrizes(LinkedList<Customer> list) {
		Iterator<Customer> itr = list.iterator();
		Customer customerObj = null;

		if (itr.hasNext()) {
			input = new Scanner(System.in);
			boolean flag = true;

			LinkedList<Integer> idList = new LinkedList<Integer>();
			while (itr.hasNext()) {
				customerObj = (Customer) itr.next();
				idList.add(customerObj.customerId);
			}
			Random random = new Random();
			LinkedList<Integer> randomIdList = new LinkedList<Integer>();
			while (randomIdList.size() < 6) {
				randomIdList.add(idList.get(random.nextInt(idList.size())));
			}

			LinkedList<Integer> adminChoiceList = new LinkedList<Integer>();
			Iterator<Customer> idItr = list.iterator();
			Customer customerObj2 = null;
			System.out.println("Ids of Customers are : ");
			while (idItr.hasNext()) {
				customerObj2 = (Customer) idItr.next();
				System.out.println(customerObj2.customerId + "-"
						+ customerObj2.customerName);
			}

			try {
				System.out.println(" Choose any 3 random Ids : ");
				
				while (adminChoiceList.size() < 3) {
					adminChoiceList.add(input.nextInt());
				}

				int index = 0;
				adminChoiceList.retainAll(randomIdList);

				Iterator<Integer> idAdminItr = adminChoiceList.iterator();
				while (idAdminItr.hasNext()) {
					flag = false;
					System.out.print("Congratulations Customer with id "+ adminChoiceList.get(index) + " won\n");
					idAdminItr.next();
					index++;
				}
				if (flag == true) {
					System.out.println("No winner..");
				}
			} catch (Exception e) {
				System.out.println(e + " -- Exception Found..");
			}
		} else {
			System.out.println("No Customer found in the list..");
		}
	}
}
