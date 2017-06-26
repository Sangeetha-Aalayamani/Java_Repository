/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ccmss.util;
/**
 *
 * @author sangeetha
 */
public interface Conventions {
  final int ADD_CUSTOMER=1,ADD_NEWCAR=2,VIEW_SPECIFIC=3,VIEW_ALL=4,GENERATE_PRIZES=5,EXIT=6,MAX_RAND_NUM=6,ADMIN_MAX_CHOICE=3;
       String COMPANIES[]={"hyundai","toyota","maruti"},
               CHOOSE_ADD_CAR="press 1 to Add purchased Car",
               MAKE_ANONIMOUS="Enter None Means You want to make him Anonymous",
               UNDEFINED="Anonymous",
               NO_MORE_CARS="entered wrong value so assumed No More Cars Purchased"; 
int CREATE_HYUNDAI=0,CREATE_TOYOTA=1,CREATE_MARUTI=2;
Boolean FOUND=true,NOT_FOUND=false;

}
