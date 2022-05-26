package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_06_For_Foreach {
	Scanner scanner = new Scanner(System.in);
	
	@Test
	public void TC_01() {		
		int number = scanner.nextInt() ;
		
		for(int i = 0 ; i <= number ; i++ ) {
			System.out.print(i +" ");
			
		}
		
	}
	
	@Test
	public void TC_02() {		
		int numbera = scanner.nextInt() ;
		int numberb = scanner.nextInt() ;
		
		for(int i = numbera ; i <= numberb ; i++ ) {
			System.out.print(i +" ");
			
		}
		
	}
	
	
	@Test
	public void TC_03() {
		int soLuongSoChan = 0 ;
		int soLuongSoLe = 0;
		
		int [] number  = {1,2,3,4,5,6,7,8,9,10,11,12,14};
		
		for(int i = 0; i <number.length ;i++) {
			if (number[i]%2==0) {
				
				soLuongSoChan++;
			} else {
				soLuongSoLe++;
			}
		}
		System.out.println("so luong so chan: " +soLuongSoChan++) ;
		System.out.println("so luong so le: " +soLuongSoLe++);
	}
	
	@Test
	public void TC_04() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int sum = 0;
		
		for(int i = a; i<= b; i++) {
			sum =sum +i;
			
		}System.out.println("tong = " +sum);
	}
	
	@Test
	public void TC_05() {
		int a = scanner.nextInt();
		int sumSoLe = 0;
		for(int i= 0; i<=a;i++) {
			if(i%2!=0) {
				sumSoLe = sumSoLe +i;
			}
		}
		System.out.println("tong = " +sumSoLe);
	}
	
	@Test
	public void TC_06() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		
		for(int i =a; i<=b;i++) {
			if(i%3==0) {
				System.out.print(i +" ");
			}
		}
	}
	
	@Test
	public void TC_07() {
		int a = scanner.nextInt();
		int giaiThua = 1;
		for(int i=1; i<=a;i++) {
			giaiThua = i*giaiThua;
		}
		System.out.println(giaiThua);
	}

}
