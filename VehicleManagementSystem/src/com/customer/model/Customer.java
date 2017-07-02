package com.customer.model;

import java.util.LinkedList;
/**
 * 
 * @author sangeetha
 *
 */
public class Customer {
	
	public int customerId, carId;
	public String customerName = "";

	public LinkedList<Car> cars = new LinkedList<Car>();

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

}