package javaBasic;

import org.testng.annotations.Test;

public class Topic_03_Casting_Type {
	static int numberStudent;
	
	@Test
	public void TC_01_tinhtong () {
		int age = 23;
		String name = "Tuan";

		if(name =="Tuan") {
		System.out.println("After 15 years, age of Tuan will be  : " +(age+15));
		
		}
		
	}
	
	@Test
	public void TC_02_ganSo() {
		int a = 3;
		int b = 4;
		 
		a= a+b;
		b= a-b;
		a= a-b;
		System.out.println("gia tri a = "+a);
		System.out.println("gia tri b = "+b);
	}
	
	@Test
	public void TC_03_soSanh() {
		int a = 5;
		int b = 4;
		
		boolean status = (a>b)? true : false;
		System.out.println("a lon hon b = " +status); 
		
		boolean status1 = (a<b)? true : false;
		System.out.println("a nho hon b = " +status1); 
	}

}
