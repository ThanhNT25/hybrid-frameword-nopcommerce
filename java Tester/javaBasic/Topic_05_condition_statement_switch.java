package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_05_condition_statement_switch {
	Scanner scanner = new Scanner(System.in);
	
	@Test
	public void TC_01() {		
		int number = scanner.nextInt() ;
		
		switch (number) {
		case 1: 
			System.out.println("One");
			break;
		case 2: 
			System.out.println("Two");
			break;
		case 3: 
			System.out.println("Three");
			break;
		case 4: 
			System.out.println("Four");
			break;
		case 5: 
			System.out.println("Five");
			break;
		case 6: 
			System.out.println("Six");
			break;
		case 7: 
			System.out.println("Seven");
			break;
		case 8: 
			System.out.println("Eight");
			break;
		case 9: 
			System.out.println("Nine");
			break;
		case 10: 
			System.out.println("Ten");
			break;
		default: 
			System.out.println("Please enter a number between 1-10");
			break;
		
		}
		
	}
	
	@Test
	public void TC_02() {
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operator = scanner.next();
		
		switch (operator) {
		case "+": 
			System.out.println("a + b = " +(a+b));
			break;
		case "-": 
			System.out.println("a - b = " +(a-b));
			break;
		case "*": 
			System.out.println("a x b = " +(a*b));
			break;
		case "/": 
			System.out.println("a / b = " +(a/b));
			break;
		default: 
			System.out.println("Vui long nhap dung dinh dang so");
			break;
		
		}

			
	}
	
	@Test
	public void TC_03() {
		int month = scanner.nextInt();
		
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("thang nay co 31 ngay");
			break;
			
		case 2:
			System.out.println("thang nay co 28 ngay");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("thang nay co 30 ngay");
			break;
		default:
			System.out.println("nhap thang trong khoang 1-12");
			break;
			
		}
	}
	

}
