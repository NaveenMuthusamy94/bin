package HOMEWORK1;
import java.io.*;

public class Calculator
{
public int add(int a, int b)
{
return a+b;
   }
public int multiply(int a, int b)
{
return a*b;
   }
public int divide(int a, int b)
{
	return a/b;
   }
public int sub(int a, int b)
{
	return b-a;
   }
public static void main(String args[])
{
Calculator obj = new Calculator();
System.out.println(obj.add(10, 20));
System.out.println(obj.multiply(10, 20));
System.out.println(obj.divide(100, 20));
System.out.println(obj.sub(10, 20));
   }
}