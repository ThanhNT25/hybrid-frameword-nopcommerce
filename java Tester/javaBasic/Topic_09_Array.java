package javaBasic;

import org.testng.annotations.Test;

public class Topic_09_Array {
	

//	String name;
//	int age;
//	String id;
//	int score;
//	
//	//ham khoi tao
//	public Topic_09_Array(String id, String name, int age, int score) {
//		
//		this.id =  id;
//		this.name =  name;
//		this.age = age;
//		this.score = score;
//	}
//	public void display() {
//		
//		System.out.println("ID: " +id);
//		System.out.println("Name: " +name);
//		System.out.println("Age: " +age);
//		System.out.println("Score: " +score);
//	}
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		Topic_09_Array []  students = new Topic_09_Array[3];
//		students[0] = new Topic_09_Array("MS01","Tuan",24,9);
//		students[1] = new Topic_09_Array("MS02","Cuong",25,8);
//		students[2] = new Topic_09_Array("MS03","Dat",26,7);
//		
//		for(int i=0;i<students.length;i++) {
//			students[i].display();
//		}
//
//	}
	
	@Test
	public void TC_01() {
		int [] number = {1,5,7,8,3};
		int max = number[0];
		
		for(int i= 0; i< number.length ; i++) {
			if(number[i] > max) {
				max = number[i];
			}
		}
		System.out.println("max = " + max);
	}

	
	@Test
	public void TC_02() {
		int [] number = {9,5,7,8,3};
		int sum = 0;
		
		for(int i= 0; i< number.length ; i++) {
			sum = number[0]+ number[number.length-1];
		}
		System.out.println("sum = " + sum);
	}

	@Test
	public void TC_03() {
		int [] number = {2,7,6,8,9,16,17,20};
		
		for(int i= 0; i< number.length ; i++) {
			if(number[i]%2==0) {
				System.out.print(+number[i]+ " ");
			}
			number[i]++;
		}
	}
	
	@Test
	public void TC_04() {
		int [] number = {3,-7,2,5,9,-6,10,12};
		int sum = 0;
		
		for(int i= 0; i< number.length ; i++) {
			if(number[i]%2!=0 && number[i] > 0) {
				sum =sum + number[i];
			}	
		}
		System.out.println("Tong so le = " +sum);
	}
	
	@Test
	public void TC_05() {
		int [] number = {3,-7,2,5,9,-6,10,12};
		
		for(int i= 0; i< number.length ; i++) {
			if(number[i]>=0 && number[i] <= 10) {
				System.out.print(+number[i]+ " ");
			}
			number[i]++;
		}
		
	}
	
	@Test
	public void TC_06() {
		int [] number = {3,5,7,30,10,5,8,23,0,-5};
		int sumTB = 0;
		int sum = 0;
		
		for(int i= 0; i< number.length ; i++) {
			sum = sum + number[i];
			
		}
		
		sumTB = sum/2;
		
		System.out.println("Tong cac so = " +sum);
		System.out.println("Tong Trung bình cộng cac so = " +sumTB);
		
	}
}
