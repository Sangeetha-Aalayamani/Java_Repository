
package com.customer.model;

public class Maruti extends Car{
    
    @Override
    public void setResaleValue()
    {
        resaleValue = price * 0.4 ;
    }
}
