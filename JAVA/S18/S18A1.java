import java.util.*;
class S18A1 extends Thread {
    S18A1(String name, int priority) {
        setName(name);
        setPriority(priority);
    }
    public void run() {
        System.out.println("Thread Name: " + getName() + ", Priority: " + getPriority());
    }
    public static void main(String[] args) throws InterruptedException {
        S18A1 t1 = new S18A1("LowPriority", Thread.MIN_PRIORITY);     // Priority 1
        S18A1 t2 = new S18A1("NormalPriority", Thread.NORM_PRIORITY); // Priority 5
        S18A1 t3 = new S18A1("HighPriority", Thread.MAX_PRIORITY);    // Priority 10

        t3.start(); // High Priority
        t3.join();  // Waits for t3 to finish
        
        t2.start(); // Normal Priority
        t2.join();  // Waits for t2 to finish
        
        t1.start(); // Low Priority
        t1.join();  // Waits for t1 to finish
    }
}


