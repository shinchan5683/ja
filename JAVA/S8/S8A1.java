import java.util.*;
class PrintThread extends Thread {
    String text;
    int count;
    
    PrintThread(String text, int count) { 
        this.text = text; 
        this.count = count; 
    }
    
    public void run() { 
        for (int i = 0; i < count; i++) 
            System.out.println(text); 
    }
}

public class S8A1 {
    public static void main(String[] args) throws InterruptedException {
        PrintThread t1 = new PrintThread("COVID19", 10);
        PrintThread t2 = new PrintThread("LOCKDOWN2020", 20);
        PrintThread t3 = new PrintThread("VACCINATED2021", 30);

        t1.start(); 
        t1.join(); // Ensures t1 finishes before starting t2

        t2.start(); 
        t2.join(); // Ensures t2 finishes before starting t3

        t3.start(); 
        t3.join(); // Ensures t3 finishes before printing the final message

        System.out.println("All threads have finished execution.");
    }
}

