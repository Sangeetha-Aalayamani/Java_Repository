package com.customer.model;

public class Hyundai extends Car {

    @Override
    public void setResaleValue() {
        resaleValue = price * 0.6;
    }
}
