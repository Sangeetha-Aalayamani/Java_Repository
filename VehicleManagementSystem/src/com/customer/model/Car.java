
package com.customer.model;

import java.util.Comparator;

public class Car implements Comparator<Car>{
 
    @Override   //This method is defined for collection sorting using car model name
    public int compare(Car o1, Car o2)
    {
        int j;
        j = o1.carModel.compareToIgnoreCase(o2.carModel);
        if(j >0)
            return 1;
        else
            return -1;
    }
    
    public int carId;
    public String carModel = "";
    public String typeOfCar = "";
    public double price,resaleValue;
    public void setResaleValue(){}
    
    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
}
