package javaOOP;

public  abstract class Computer {

	// Normal Method
	public void showComputerPerfomance() {
		System.out.println("Show computer perfomance");
	}
	
	// Abstract Method
	// Khung để cho các class con kế thừa nó phảu override lại (implement) lại
	public abstract void showComputerRam();

}
