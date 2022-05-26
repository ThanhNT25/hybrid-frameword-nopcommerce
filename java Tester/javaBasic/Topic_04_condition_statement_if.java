package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_04_condition_statement_if {
	Scanner scanner = new Scanner(System.in);
	
	@Test
	public void TC_01_chanLe () {		
		int number = scanner.nextInt();
		
		if(number % 2 ==0 ) {
			System.out.println("so " +number +" la so chan");
		
		}
		else {
			System.out.println("so " +number +" la so le");
		}
		
		number = number % 2;
		boolean status = number ==0;
		System.out.println(status);
		
		if(status) {
			System.out.println("so " +number +" la so chan");
		
		}
		else {
			System.out.println("so " +number +" la so le");
		}
		
	}
	
	@Test
	public void TC_02() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		
		if(numberA >= numberB) {
			System.out.println(numberA+ " Lon hon hoc bang " +numberB);
		}else {
			System.out.println(numberA+ " nho hon " +numberB);
		}
	}
	
	@Test
	public void TC_03() {
		String firstStudent = scanner.nextLine();
		String secondStudent = scanner.nextLine();
		
		if(firstStudent.equals(secondStudent)) {
			System.out.println("Hai sinh vien giong ten nhau");
		} else {
			System.out.println("Hai sinh vien khac ten nhau");
		}
	}
	
	@Test
	public void TC_04() {
		int numberA = scanner.nextInt();
		int numberB = scanner.nextInt();
		int numberC = scanner.nextInt();
		
		if(numberA > numberB && numberA > numberC) {
			System.out.println(numberA + " la so lon nhat ");
		}else if (numberB > numberC) {
			System.out.println(numberB + " la so lon nhat ");
		}else {
			System.out.println(numberC + " la so lon nhat ");
		}
		
	}
	
	@Test
	public void TC_05() {
		int numberA = scanner.nextInt();
		
		if(10 < numberA && numberA <100) {
			System.out.println(numberA + " nan trong khoang 10 -100 ");
		} else {
			System.out.println(numberA + " khong nan trong khoang 10 -100 ");
		}
	}
		
	@Test
	public void TC_06() {
		float scoreA = scanner.nextFloat();
		
		if(0 < scoreA && scoreA <5) {
			System.out.println( "Diem D");
		} else if (5 <= scoreA && scoreA <7.5) {
			System.out.println( "Diem C");
		} else if(7.5 <= scoreA && scoreA <8.5){
			System.out.println( "Diem B");
		}else if (8.5 <= scoreA && scoreA <=10){
			System.out.println( "Diem A");
		}else {
			System.out.println( "Diem khong hop le");
		}
	}
		
	@Test
	public void TC_07() {
		int monthy = scanner.nextInt();
		
		if(monthy ==1 || monthy ==3 || monthy ==5 || monthy ==7 || monthy ==8 || monthy ==10 || monthy ==12 ) {
			System.out.println( "Thang " +monthy+ " co 31 ngay");
		}else if(monthy == 2) {
			System.out.println( "Thang " +monthy+ " co 28 ngay");
		}else if(monthy ==4 || monthy ==6 || monthy ==11 || monthy ==9) {
			System.out.println( "Thang " +monthy+ " co 30 ngay");
		}
		
	}

}
