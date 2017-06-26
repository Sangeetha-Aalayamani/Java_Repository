/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sms.entities;
/**
 *
 * @author sangeetha
 */


public class StudentStructure
{
    public
	String name,section,address;
    public
        int id,age,numCourses;
    public 
        Subject[] course=new Subject[numCourses];

}

