package javaOOP;

public class Topic_04_Non_Access_Modifier {
	
	// Static : variable/ method
	// dùng cho tất cả các instance/ object
	// phạm vi cho toàn bộ system sử dụng nó
	// có thể override được
	static String browserName = "Chrome";
	
	// Non static 
	String serverName = "Testing";
	final String colorCar = "Red";
			

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(browserName);
		
		browserName ="Firefox";
		System.out.println(browserName);
		
		Topic_04_Non_Access_Modifier topic = new Topic_04_Non_Access_Modifier();
		System.out.println(topic.serverName);
		
		// không được phép gán lại giá trị 
		System.out.println(topic.colorCar);
				

	}

}
