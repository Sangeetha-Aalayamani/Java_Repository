package com.sample.inherit;


	
	class A{
		  public void fun1(int x){
		   System.out.println("int in A" +x);
		  }
		  
		}

		class B extends A{
		  public void fun2(int x,int y){
		   fun1(6);  // prints "int in A" 
		   System.out.println("int in B"+(x+y));  
		  }
		}
		public class Inheritance {
		  public static void main(String[] args){
		   B obj= new B();
		   obj.fun2(2,5); 
		   }
		}
