package HOMEWORK1;
import java.io.*;
public class Singleton {

   private static Singleton singleton = new Singleton( );

   private Singleton() { }

 
   public static Singleton getInstance( ) {
      return singleton;
   }
   public static void play( ) {
      System.out.println("demoMethod for DVD Play");
   }
   public static void open( ) {
      System.out.println("demoMethod for DVD open");
   }
   public static void close( ) {
      System.out.println("demoMethod for DVD Close");
   }
   public static void openbuttonpressed( ) {
      System.out.println("demoMethod for Button press");
   }
   public static void push( ) {
      System.out.println("demoMethod for push");
   }
 
   public static void demoMethod( ) {
      System.out.println("demoMethod for singleton class");
   }
}