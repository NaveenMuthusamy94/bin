package edu.umb.cs680.hw14;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

public class ParetoComparatorTest {
	
	private static LinkedList<Car> cars = new LinkedList<Car>();
	
	
	@BeforeAll
	private static void setUpOfCars() {
		
		Car c1 = new Car("800", "Maruthi", 1994, 12000, 1000);
		cars.add(c1);
		Car c2 = new Car("Zen", "Maruthi", 1998, 19000, 4000);
		cars.add(c2);
		Car c3 = new Car("X7", "BMW", 2014, 3000, 7000);
		cars.add(c3);
		Car c4 = new Car("A8", "BMW", 2014, 1000, 5000);
		cars.add(c4);
		for(int i=0;i<4;i++) {
			cars.get(i).setDominationCount(i);
		}
		Collections.sort(cars,(Car C1, Car C2) -> (int)C1.getDominationCount()-(int)C2.getDominationCount());
	}
	
	@Test
	public void testForFirstCar() {
		assertEquals(0, cars.get(0).getDominationCount());
	}
	
	@Test
	public void testForSecondCar() {
		assertEquals(1, cars.get(1).getDominationCount());
	}
	
	@Test
	public void testForthirdCar() {
		
		assertEquals(2, cars.get(2).getDominationCount());
	}
	
	@Test
	public void testForFourthCar() {
		
		assertEquals(3, cars.get(3).getDominationCount());
	}
	
}
