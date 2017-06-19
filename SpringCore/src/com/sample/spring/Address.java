package com.sample.spring;
/**
 * 
 * @author user
 *
 */
public class Address {
	
	private String address;
	private String street;
	private String city;
	
	public Address(String address, String street, String city) {
		super();
		this.address = address;
		this.street = street;
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [address=" + address + ", street=" + street + ", city="
				+ city + "]";
	}
	
}
