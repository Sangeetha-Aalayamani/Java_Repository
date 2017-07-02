
package com.customer.model;

public class Toyota extends Car{
 
    @Override
    public void setResaleValue()
    {
        resaleValue = price * 0.8 ;
    }
}
