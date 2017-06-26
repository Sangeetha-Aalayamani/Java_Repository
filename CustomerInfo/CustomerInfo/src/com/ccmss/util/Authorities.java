/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccmss.util;

import com.ccmss.entities.*;
import java.util.*;

/**
 *
 * @author Sangeetha
 */
public class Authorities implements com.ccmss.util.Conventions {

    Scanner scanInput = new Scanner(System.in);
    Customer customerTemp;
    Car carTemp = null;
    Random rand = new Random();
    String inputString;

    public Customer newCustomer(int custId) {
        Boolean addCar = NOT_FOUND;
        customerTemp = new Customer();
        System.out.println("Enter Details of the Customer");
        customerTemp.setCustId(custId);
        System.out.println("Enter name of the customer");
        inputString = null;
        inputString = scanInput.nextLine();
        if (inputString.isEmpty()) {
            System.out.println(MAKE_ANONIMOUS);
            inputString = UNDEFINED;
        }
        customerTemp.setCustName(inputString);
        try {

            System.out.println(CHOOSE_ADD_CAR);
            if (Integer.parseInt(scanInput.nextLine()) == 1) {
                addCar = FOUND;
            }

            while (addCar) {
                customerTemp.setPurchasedCars(carDetails(customerTemp.getPurchasedCars()));
                System.out.println(CHOOSE_ADD_CAR);
                if (Integer.parseInt(scanInput.nextLine()) != 1) {
                    addCar = NOT_FOUND;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println(NO_MORE_CARS);
        }
        return customerTemp;
    }

    public LinkedList<Car> addMoreCars(LinkedList<Car> linkCars) {
        LinkedList<Car> newPurchasedCars = new LinkedList<Car>();
        try {
            Boolean addCar = FOUND;
            while (addCar) {
                newPurchasedCars.add(carDetails(linkCars));
                System.out.println(CHOOSE_ADD_CAR);
                if (Integer.parseInt(scanInput.nextLine()) != 1) {
                    addCar = NOT_FOUND;
                }
            }

        } catch (NumberFormatException e) {
            System.out.println(NO_MORE_CARS);
        }
        return newPurchasedCars;
    }

    public Car carDetails(LinkedList<Car> linkCars) {
        while (FOUND) {
            int carCompany;

            Boolean create = FOUND;
            System.out.println("Enter the name of the company of the car purchased by customer");
            inputString = null;
            inputString = scanInput.nextLine();
            if (inputString.isEmpty()) {
                System.out.println(MAKE_ANONIMOUS);
                inputString = UNDEFINED;
            }

            carCompany = Arrays.asList(COMPANIES).indexOf(inputString.toLowerCase());
            switch (carCompany) {
                case CREATE_HYUNDAI:
                    carTemp = new Hyundai();

                    break;
                case CREATE_TOYOTA:
                    carTemp = new Toyota();
                    break;
                case CREATE_MARUTI:
                    carTemp = new Maruti();
                    break;

                default:
                    System.out.println("Unfortunately Company Not Available So try again and choose from Hyundai,Toyota,Maruti");
                    create = NOT_FOUND;
            }
            if (create) {
                do {
                    System.out.println("Add carId");
                    inputString = null;
                    inputString = scanInput.nextLine();
                    if (inputString.isEmpty()) {
                        System.out.println(MAKE_ANONIMOUS);
                        inputString = UNDEFINED;
                    }
                } while (isValidCar(linkCars, inputString));
                carTemp.setCarId(inputString);
                System.out.println("Add carModel");
                inputString = null;
                inputString = scanInput.nextLine();
                if (inputString.isEmpty()) {
                    System.out.println(MAKE_ANONIMOUS);
                    inputString = UNDEFINED;
                }
                carTemp.setCarModel(inputString);
                carTemp.setCarCompany(COMPANIES[carCompany]);
                float carPrice = 0;
                while (FOUND) {
                    try {
                        System.out.println("Add Car Price");
                        carPrice = Integer.parseInt(scanInput.nextLine());
                        break;
                    } catch (Exception exp) {
                        System.out.println("Wrong Input Enter again");
                    }
                }
                carTemp.setCarPrice(carPrice);

                carTemp.setCarResaleValue();
                return carTemp;
            }

        }
        return null;
    }

    public void displayAllCustomers(ArrayList<Customer> customersRecord) {
        customerTemp = new Customer();

        Iterator customersRecordsIterator = customersRecord.iterator();
        if (customersRecordsIterator.hasNext()) {
            System.out.println("Cutomer Id " + "\t" + "Customer Name : ");

            while (customersRecordsIterator.hasNext()) {
                customerTemp = (Customer) customersRecordsIterator.next();
                System.out.println(customerTemp.getCustId() + "\t" + customerTemp.getCustName());
            }
        } else {
            System.out.println("Empty Record");
        }
    }

    public void displayParticular(Customer customerTemp) {
        try {
            if (customerTemp != null) {

                sortCars(customerTemp.getPurchasedCars());
                System.out.print(customerTemp.getCustName()
                        + " with id "
                        + customerTemp.getCustId()
                        + " Purchased : ");

                Iterator purchasedCarsItr = customerTemp.getPurchasedCars().iterator();
                if (purchasedCarsItr.hasNext()) {
                    System.out.println("");
                    int carNum = 1;

                    while (purchasedCarsItr.hasNext()) {
                        System.out.println("car " + carNum + ":");
                        carTemp = (Car) purchasedCarsItr.next();
                        System.out.println(carTemp.getCarCompany()
                                + "-" + carTemp.getCarId()
                                + "-" + carTemp.getCarModel()
                                + " at the cost " + carTemp.getCarPrice()
                                + " and have resale value of "
                                + carTemp.getCarResaleValue());
                        carNum++;
                    }
                } else {
                    System.out.println("No Cars");
                }

            } else {
                System.out.println("customer not present");
            }
        } catch (NumberFormatException exp) {
            System.out.println("Wrong Value");
        }
    }

    /* public void sortCustomers(ArrayList<Customer> customerArray) {
     System.out.println("press 1 to sort the list of customers accordig to the names");
     try {
     if (Integer.parseInt(scanInput.nextLine()) == 1) {
     Collections.sort(customerArray, new Customer());
     }
     } catch (NumberFormatException exp) {
     }
     }
     */
    public void sortCars(LinkedList<Car> carArray) {
        Collections.sort(carArray, new Hyundai());
    }

    public Customer isValidCust(ArrayList<Customer> customerArray, int custId) {
        //  Boolean result = false;

        Iterator customersListIterator = customerArray.iterator();
        while (customersListIterator.hasNext()) {
            customerTemp = (Customer) customersListIterator.next();
            if (customerTemp.getCustId() == custId) {
                
                return customerTemp;
            }

        }
        return null;
    }

    public Boolean isValidCar(LinkedList<Car> carArray, String carId) {
        //  Boolean result = false;

        Iterator carListIterator = carArray.iterator();
        while (carListIterator.hasNext()) {
            carTemp = (Car) carListIterator.next();
            if (carTemp.getCarId().equalsIgnoreCase(carId)) {
                System.out.println("Id Already Exists");
                return true;
            }

        }
        return false;
    }

    public ArrayList<Integer> generatePrizes(int idcount) { // remove idCount and use size()

        int randomNumber;
        ArrayList<Integer> arrayOfId = new ArrayList<>();
        ArrayList<Integer> adminChoice = new ArrayList<>();

        while (arrayOfId.size() < MAX_RAND_NUM) { //TODO: remove hard coded values
            randomNumber = rand.nextInt(idcount);
            arrayOfId.add(randomNumber);
        }
        System.out.println("Enter "+ADMIN_MAX_CHOICE+" random ID's ");
        while (adminChoice.size() < ADMIN_MAX_CHOICE) { //TODO: remove hard coded values
            try {
                adminChoice.add(Integer.parseInt(scanInput.nextLine()));

            } catch (NumberFormatException exp) {
                System.out.println("wrong Input");
            }
        }
        adminChoice.retainAll(arrayOfId);
          return adminChoice;
    }
}
