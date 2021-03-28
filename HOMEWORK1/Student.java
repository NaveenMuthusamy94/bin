package edu.umb.cs680.hw04;

enum StudentStatus{
	INSTATE(1000),OUTSTATE(2000),INTL(3000);
	private float tution;
	StudentStatus(float m){
		this.tution = m;
	}
	public float getTution() {
		return this.tution;
	}	
	
}

public class Student {
	
	private float tution;
	private String name;
	private int i20num;
	private String usAddr;
	private int yrsInState;
	private String foreignAddr;
	private StudentStatus status;
	
	protected Student(String name, String usAddr, int years, int i20num, String foreignAddr, StudentStatus status) {
		this.name = name;
		this.usAddr = usAddr;
		this.yrsInState = years;
		this.i20num = i20num;
		this.foreignAddr = foreignAddr;
		this.status = status;
	}
	
	public float getTution() {
		return this.status.getTution();
	}
	
	public String getName() {
		return this.name;
	}
	
	public StudentStatus getStatus() {
		return this.status;
	}
	
	public int geti20Num() {
		return this.i20num;
	}
	
	public String getUSAddr() {
		return this.usAddr;
	}
	
	public String getForeignAddr() {
		return this.foreignAddr;
	}
	
	public int getYrsInState() {
		return this.yrsInState;
	}
}
