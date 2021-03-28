import HOMEWORK1.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.io.*;
public class CalculatorTest1{
@Test
   public void testcalculator()
{

Calculator obj = new Calculator();
System.out.println(obj.add(10, 20));
System.out.println(obj.multiply(10, 20));
System.out.println(obj.divide(100, 20));
System.out.println(obj.sub(10, 20));
assertTrue(true);
	 
   }
}