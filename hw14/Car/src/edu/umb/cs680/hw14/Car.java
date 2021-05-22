package edu.umb.cs680.hw14;

import java.util.ArrayList;

public class Car {
	private String model,make;
	private int mileage, year;
	private float price;
	private ArrayList<Car> cars;
	private int dominationCount = 0;
	
	public Car(String model,String make,int year,float price,int mileage) {
		
		this.year = year;
		this.price = price;
		this.mileage = mileage;
		this.model = model;
		this.make = make;
	}
	
	public float getPrice() {
		return this.price;
	}
	public String getModel() {
		return this.model;
	}
	public String getMake() {
		return this.make;
	}
	public int getMileage() {
		return this.mileage;
	}
	public int getYear() {
		return this.year;
	}
	public void setCarList(ArrayList<Car> cars) {
		this.cars=cars;
	}
	
	public int getDominationCount() {
		
		return this.dominationCount;
	}
	
	public void dominationCount() {
		int count=0;
		for(Car c: cars) {
			if(this.price >= c.getPrice() && this.year>= c.getYear() && this.mileage>=c.getMileage()){
				count++;
			}
		}
		this.setDominationCount(count);
	}
	
	public void setDominationCount(int dominationCount) {
		this.dominationCount = dominationCount;
	}
}
