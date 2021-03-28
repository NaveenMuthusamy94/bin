 package edu.umb.cs680.hw04;

public class StudentFactory {
	
	private StudentFactory() {}
	
	public static Student createInStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, usAddr, yrsInState, 0, null, StudentStatus.INSTATE);
	}
	
	public static Student createOutStateStudent(String name, String usAddr, int yrsInState) {
		return new Student(name, usAddr, yrsInState, 0, null, StudentStatus.OUTSTATE);
	}
	
	public static Student createIntlStudent(String name, String usAddr, int i20num, String foreignAddr) {
		return new Student(name, usAddr, 0, i20num, foreignAddr, StudentStatus.INTL);
	}
	
	/*public static void main(String[] args) {
		Student s1 = createInStateStudent("Mark" , "Boston Downtown", 23);
		System.out.println("Name: " + s1.getName());
		System.out.println("Years in state: " + s1.getYrsInState());
		System.out.println("US address: " + s1.getUSAddr());
		System.out.println("I-20 number: " + s1.geti20Num());
		System.out.println("Foreign Address: " + s1.getForeignAddr());
		System.out.println("Student status: " + s1.getStatus());
		
	}*/
}
