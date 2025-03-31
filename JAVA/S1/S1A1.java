import java.util.*;
public class S1A1 extends Thread {
public static void main(String[] args) {
 for(char ch='A'; ch<='Z'; ch++) {
      System.out.println(ch);
  try { 
        Thread.sleep(2000);
   } catch (InterruptedException e) { 
     System.out.println("Thread Interrputed!");
   }
  }
 }
}
 
