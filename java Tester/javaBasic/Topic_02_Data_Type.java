package javaBasic;

import org.testng.annotations.Test;

public class Topic_02_Data_Type {
	static int numberStudent;
	
	@Test
	public void TC_01_tinhtong () {
		int a = 6;
		int b = 2;
		
		int tong = a+b;
		int hieu = a-b;
		int tich = a*b;
		int thuong = a/b;
		
		System.out.println("Tổng của 2 số là : " +tong);
		System.out.println("Hiệu của 2 số là : " +hieu);
		System.out.println("Tích của 2 số là : " +tich);
		System.out.println("Thương của 2 số là : " +thuong);
	}
	
	@Test
	public void TC_02_tinhDientichChuvi () {
		float a = 7.5f;
		float b = 3.8f;
		
		float dientich = a*b;
		float chuvi = (a+b)*2;
		
		System.out.println("diện tích : " +dientich);
		System.out.println("chu vi : " +chuvi);
		
	}
	
	@Test
	public void TC_03() {
		String name = "Automation Testing";
		
		
		if(name == "Automation Testing") {
			System.out.println("Hello Automation Testing");
		}
		else {
			System.out.println("Not Automation Testing");
		}
	}

}
