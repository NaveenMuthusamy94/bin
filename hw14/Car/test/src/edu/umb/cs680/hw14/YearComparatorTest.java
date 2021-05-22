package edu.umb.cs680.hw14;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Collections;
import java.util.LinkedList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class YearComparatorTest {
	
	private static LinkedList<Car> cars = new LinkedList<Car>();
	
	private String[] CarToString(Car c) {
		String[] info = {c.getModel(), c.getMake(), Integer.toString(c.getYear()) , Float.toString(c.getPrice()), Integer.toString(c.getMileage())};
		return info;
	}
	
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
		Collections.sort(cars,(Car C1, Car C2) -> (int)C1.getYear()-(int)C2.getYear());
	}
	
	@Test
	public void testForFirstCar() {
		String[] expected = {"A8", "BMW", "2014", "1000.0", "5000"};
		String[] actual = CarToString(cars.get(0));
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testForSecondCar() {
		String[] expected = {"X7", "BMW", "2014", "3000.0", "7000"};
		String[] actual = CarToString(cars.get(1));
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testForThirdCar() {
		String[] expected = {"800", "Maruthi", "1994", "12000.0", "1000"};
		String[] actual = CarToString(cars.get(2));
		assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testForFourthCar() {
		String[] expected = {"Zen", "Maruthi", "1998", "19000.0", "4000"};
		String[] actual = CarToString(cars.get(3));
		assertArrayEquals(expected, actual);
	}

}
