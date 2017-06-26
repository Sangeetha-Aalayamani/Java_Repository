/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccmss.Main;

import java.util.*;
import com.ccmss.entities.Customer;

/**
 *
 * @author Sangeetha
 */
public class Main implements com.ccmss.util.Conventions {

    public static void main(String[] args) {
        int choice, idCount = 1, custId;
        Boolean value = NOT_FOUND;
        Customer customerTemp = new Customer();
        Scanner scanInput = new Scanner(System.in);
        com.ccmss.util.Authorities authorities = new com.ccmss.util.Authorities();
        ArrayList<com.ccmss.entities.Customer> customersList = new ArrayList<>();
        while (FOUND) {
            try {
                System.out.println("Enter Your Choice");
                System.out.println("1:Add new Customer\n"
                        + "2:Add new car to existing customer\n"
                        + "3:View details of a specific customer\n"
                        + "4:View Details of all customers\n"
                        + "5:Generate Prizes\n"
                        + "6:Exit");
                choice = Integer.parseInt(scanInput.nextLine());
                switch (choice) {
                    case ADD_CUSTOMER: // TODO: constants must be in uppercase and words separated with _
                        customersList.add(authorities.newCustomer(idCount));
                        idCount++;
                        break;
                    case ADD_NEWCAR:
                        System.out.println("Enter customer id");
                        custId = Integer.parseInt(scanInput.nextLine());
                        customerTemp = authorities.isValidCust(customersList, custId);
                        Customer customerTempUpdated = customerTemp;
                        if (customerTemp != null) {
                            customerTempUpdated.setPurchasedCars(authorities.addMoreCars(customerTemp.getPurchasedCars()));
                            customersList.set(customersList.indexOf(customerTemp), customerTempUpdated);
                        } else {
                            System.out.println("Invalid Customer Id");
                        }
                        break;
                    case VIEW_SPECIFIC:
                        System.out.println("enter the customer id");
                        custId = Integer.parseInt(scanInput.nextLine());
                        customerTemp = authorities.isValidCust(customersList, custId);
                        if (customerTemp != null) {
                            authorities.displayParticular(customerTemp);
                        } else {
                            System.out.println("Invalid Customer Id");
                        }

                        break;
                    case VIEW_ALL:
                        authorities.displayAllCustomers(customersList);
                        break;
                   case GENERATE_PRIZES:
                ArrayList<Integer> winners=authorities.generatePrizes(idCount);
                if(winners.size()>0)
                 {
                for(int i=0;i<winners.size();i++)
                {System.out.println("\t\t\t Congratulations!!!!!");
                    customerTemp=authorities.isValidCust(customersList, winners.get(i));
                 authorities.displayParticular(customerTemp);
                }
                 }
                else
                 System.out.println("\t\t\t UNFORTUNATELY No Winner Found ");
                
                 break;
                     
                    case EXIT:
                        System.exit(0);

                }
            } catch (NumberFormatException exp) {
                System.out.println("Wrong Input Start Again");
            }
        }
    }

}
