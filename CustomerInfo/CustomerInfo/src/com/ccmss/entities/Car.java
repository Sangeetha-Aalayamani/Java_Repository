/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccmss.entities;

import java.util.Comparator;

/**
 *
 * @author Sangeetha
 */
public abstract class Car implements Comparator<Car>{

    private String carId;
    private float carPrice;
    protected double carResaleValue;
    private String carModel,carCompany;


    
    
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setCarPrice(float carPrice) {
        this.carPrice = carPrice;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
public void setCarCompany(String carCompany) {
        this.carCompany = carCompany;
    }
public String getCarCompany() {
        return this.carCompany;
    }

    public String getCarId() {
        return carId;
    }

    public float getCarPrice() {
        return carPrice;
    }

    public String getCarModel() {
        return carModel;
    }

   public abstract void setCarResaleValue();

    public double getCarResaleValue() {
        return carResaleValue;
    }
    public int compare(Car c1, Car c2) {
        int greater=c1.getCarModel().compareToIgnoreCase(c2.getCarModel());
        if(greater>0){
            return 1;
        } else {
            return -1;
        }
    }
}
