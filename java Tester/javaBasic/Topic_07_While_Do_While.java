package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_07_While_Do_While {
	 static Scanner scanner = new Scanner(System.in);
	 
	 public static void mani(String[]agrs) {
		 TC_01();
		 TC_02();
	 }
	
	@Test
	public static void TC_01() {		
		int number = scanner.nextInt() ;
	
		while(number < 100) {	
				if( number % 2 == 0) {
					System.out.println(number);
					
				}
				number++;
		}
	}
	
	@Test
	public static void TC_02() {		
		int numbera = scanner.nextInt() ;
		int numberb = scanner.nextInt() ;
	
		while(numbera < numberb) {
			
				if(numbera %3==0 && numbera %5==0) {
					System.out.print(numbera +" ");
				}
				numbera++;	
		}
	}
	
	@Test
	public void TC_03() {		
		int numbera = scanner.nextInt() ;
		int numberb = scanner.nextInt() ;
		int sumSoLe = 0;
	
		while(numbera <= numberb) {
			
				if(numbera % 2 !=0) {
					sumSoLe += numbera;	
					//sumSoLe = sumSoLe +numbera
				}				
			numbera++;
		}
		System.out.println( sumSoLe);
		
	}
	
	@Test
	public void TC_04() {		
		int numbera = scanner.nextInt() ;
		int numberb = scanner.nextInt() ;
	
		while(numbera <= numberb) {
			
				if(numbera%3==0) {
					System.out.println(+numbera+ " ");				
				}				
		numbera++;
		}
		
	}
	
	@Test
	public void TC_05() {		
		int numberb = scanner.nextInt() ;
		int giaithua =1;
	
		while(0 < numberb) {
			
			giaithua *= numberb;
			numberb--;
									
		}
		System.out.println("giai thua = " +giaithua);	
	}
	
}