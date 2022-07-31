package javaOOP;

public class Topic_01_Class_Object_Student {
	public int studentID;
	private String studentName;
	private Float knowledgePoint;
	private Float practicePoint;
	

	private final int getStudentID() {
		return studentID;
	}


	private final void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	private final String getStudentName() {
		return studentName;
	}


	private final void setStudentName(String studentName) {
		this.studentName = studentName;
	}


	private final Float getKnowledgePoint() {
		return knowledgePoint;
	}


	private final void setKnowledgePoint(Float knowledgePoint) {
		this.knowledgePoint = knowledgePoint;
	}


	private final Float getPracticePoint() {
		return practicePoint;
	}


	private final void setPracticePoint(Float practicePoint) {
		this.practicePoint = practicePoint;
	}
	
	private Float getAveragePoint() {
		return(this.knowledgePoint + this.practicePoint*2)/3;
	}
	
	private void showStudentInfor() {
		System.out.println("*********************************");
		System.out.println("Student ID = " +getStudentID());
		System.out.println("Student Name = " +getStudentName());
		System.out.println("Student knowledg point = " +getKnowledgePoint());
		System.out.println("Student practice point = " +getPracticePoint());
		System.out.println("Student Average point = " +getAveragePoint());
		System.out.println("*********************************");
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Topic_01_Class_Object_Student firstStudent = new Topic_01_Class_Object_Student();
		firstStudent.setStudentID(202300);
		firstStudent.setStudentName("Nguyen Van A");
		firstStudent.setKnowledgePoint(8.0f);
		firstStudent.setPracticePoint(7.8f);
		firstStudent.showStudentInfor();
		
		Topic_01_Class_Object_Student secondStudent = new Topic_01_Class_Object_Student();
		secondStudent.setStudentID(202333);
		secondStudent.setStudentName("Nguyen Van B");
		secondStudent.setKnowledgePoint(5.0f);
		secondStudent.setPracticePoint(6.8f);
		secondStudent.showStudentInfor();

	}

}
