/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ccmss.entities;
import java.util.Comparator;
import java.util.LinkedList;

public class Customer implements Comparator<Customer> {
private int custId;
private String custName;

private LinkedList<Car> purchasedCars=new LinkedList<>();

 public int compare(Customer c1, Customer c2) {
        
            return c1.getCustName().compareToIgnoreCase(c2.getCustName());
        
    }




public void setCustId(int custId)
{this.custId=custId;
}
public int getCustId()
{return custId;
}
public void setCustName(String custName)
{this.custName=custName;}
public String getCustName()
{return this.custName;}
public void setPurchasedCars(Car purchasedCars)
{
    this.purchasedCars.add(purchasedCars);
}
public void setPurchasedCars(LinkedList<Car> purchasedCars)
{
    this.purchasedCars.addAll(purchasedCars);
}
   public LinkedList<Car> getPurchasedCars()
    {
        return purchasedCars;
    }
}

