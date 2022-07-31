package javaOOP;

public class Topic_02_Variable_Property_Method {
	
	static int studentNumber;
	static float studentPrice;
	static String studentCountry;
	static boolean studentStatus;
	
	// Access Modifiler
	// Datatype
	// Variable name
	// Variable value
	private String studentName ="Automation FC"; //biến toàn cục (global variable )
	
	// Static variable: dùng và gàn lại được
	public static String studentAddress ="HCM";
	
	// Dùng trog phạm vi class này (cho tất cả instance/ object dùng)
	private static String studentPhone ="0987788443";
	
	// Final variable :  không cho phép gán lại
	// Cố định dữ liệu không được phép thay đổi trong quá trình chạy code
	final String country ="VN";
	
	// Static final variable : hằng số (constant )
	// nó không được ghi đè
	// có thể truy cập rộng rãi cho tất cả các instance/ thread
	static final float PI_Number = 3.14235444f;
	
	// Access modifiler: default
	int studentID = 10004;
	
	//Hàm (method) - static
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// local variable - biến cục bộ :  hàm
		String studentName = "Automation FC";
		
		if(studentName.startsWith("Automation")) {
			// Local variable -  biến cục bộ : block code
			int number = 100;
		}

	}
	
	public Topic_02_Variable_Property_Method() {
		// Local variable - biến cục bộ : constructor
		String studentName = "Automation FC";
	}
	
	// Hàm (Method) - non static
	public void display() {
		//Local variable - biến cục bộ : hàm
		String studentName = "Automation FC";
	}

}
