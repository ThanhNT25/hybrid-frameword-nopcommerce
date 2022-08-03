package javaOOP;

public class Topic_05_This_Super {
	private int firstNumber;
	private int secondNumber;
	
	public Topic_05_This_Super(int firstNumber, int secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
	}
	
	public void sumNumber() {
		System.out.println(this.firstNumber + this.secondNumber);
	}
	
	public void showNumber() {
		this.sumNumber();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Topic_05_This_Super topic = new Topic_05_This_Super(15,7);
		topic.sumNumber();

	}

}
