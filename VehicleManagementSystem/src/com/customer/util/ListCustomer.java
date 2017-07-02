package com.customer.util;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import com.customer.model.Car;
import com.customer.model.Customer;
/**
 * 
 * @author sangeetha
 *
 */
public class ListCustomer {
    
	Scanner input;
    public void listAllCustomers(LinkedList<Customer> list)
    {
        Iterator<Customer> itr= list.iterator();
        if(itr.hasNext())
        {
            while(itr.hasNext())
            {
                Customer customerObj;
                customerObj = (Customer)itr.next();
                System.out.println("\n-------- Customer Details -------- \n");
                System.out.println("Customer Id : "+customerObj.customerId);
                System.out.println("Customer Name : "+customerObj.customerName+"\t");
                Iterator<Car> itrSub;
                itrSub = customerObj.cars.iterator();     
                Collections.sort(customerObj.cars,new Car());
                while(itrSub.hasNext())
                {
                    Car carObj=(Car)itrSub.next();
                    System.out.println("\nType of car : "+carObj.typeOfCar+"\n Car ID : "+carObj.carId+"\n Car Model : "+carObj.carModel+"\n Car Price : "+carObj.price+"\n Car Resale Price : "+carObj.resaleValue);
                }
            }
        }
        else
        {
            System.out.print("No customer found in the list..");
        }
    }
    
    
    public void listOneCustomer(LinkedList<Customer> list)
    {
        input = new Scanner(System.in);
        int id;
        boolean found = false;
        
        Iterator<Customer> itr = list.iterator();
        Iterator<Customer> itr2 = list.iterator();
        
        Customer customerObj = null;
        if(itr.hasNext())
        {
            try
            {
                System.out.println("Ids of Customers are : ");
                while(itr.hasNext())
                {
                    customerObj = (Customer) itr.next();
                    System.out.println(customerObj.customerId+"-"+customerObj.customerName+" ");
                }
                System.out.println("Choose the id of Customer : ");
                id = input.nextInt();
                while(itr2.hasNext())
                {
                    customerObj=(Customer)itr2.next();
                    if(id == customerObj.customerId)
                    {
                        found = true;
                        break;
                    }
                }
                if(found == false)
                    System.out.println("Id not found");
                else
                {
                    System.out.println("\n------Customer Details------- \n");
                    System.out.println("Customer Id : "+customerObj.customerId);
                    System.out.println("Customer Name : "+customerObj.customerName+"\t");
                    Iterator<Car> itrSub;
                    itrSub = customerObj.cars.iterator();
                    while(itrSub.hasNext())
                    {
                        Car carObj=(Car)itrSub.next();
                        System.out.println(" Type of car : "+carObj.typeOfCar+"\n Car ID : carObj.carId+\n Car Model : "+carObj.carModel+"\n Car Price : "+carObj.price+"\n Car Resale Price : "+carObj.resaleValue);
                    }
                }
            }
            catch(Exception e)
            {
                System.out.println(e+" -- Exception Found");
            }
        }
        else
        {
            System.out.println("No Customer Found in the list...");
        }    
    }
    
}
