package javaBasic;

import java.util.Scanner;

import org.testng.annotations.Test;

public class Topic_10_String {
	static Scanner scanner = new Scanner(System.in);
	
	@Test
	public void TC_01() {
		String pageName ="Automation FC";
		char pageNameArray[] = pageName.toCharArray();
		int count =0;
		for(char character : pageNameArray) {
			if(character <= 'Z' && character >='A') {
				count++;
			}
		}
		System.out.println("Sum of uppercase = " + count);
	}
	
	@Test
	public void TC_02() {
		String pageName ="Automation Testing 345 Tutorials Online 789";
		char pageNameArray[] = pageName.toCharArray();
		int count =0;
		for(char character : pageNameArray) {
			if(character =='a') {
				count++;
			}
		}
		System.out.println("Sum of text a = " + count);
		System.out.println("Chuoi co chua tu Testing => true: " + pageName.contains("Testing"));
		System.out.println("Chuoi bat dau voi Automation => true : " + pageName.startsWith("Testing"));
		System.out.println("Chuoi ket thuc voi Online => false  : " + pageName.endsWith("Online"));
		System.out.println("Vi tri Tutorials la 23 => true  : " + pageName.indexOf("Tutorials"));
		pageName = pageName.replaceAll("Online", "Offline");
		System.out.println(pageName);
		
		int countNumber =0;
		for(char character : pageNameArray) {
			if(character >= '0' && character <='9') {
				countNumber++;
			}
		}
		System.out.println("Sum of number = " + countNumber);
	}
	
	@Test
	public void TC_03() {
		String chuoiKyTu  = scanner.nextLine();
		System.out.println(chuoiKyTu);
		//doi sang kieu mang
		char chuoiKyTuArray[] = chuoiKyTu.toCharArray();
		
		for(int i = chuoiKyTuArray.length-1; i>=0; i--) {
			System.out.print(chuoiKyTuArray[i]);
		}
		
	}

}
