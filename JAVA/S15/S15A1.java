import java.util.*;
class S15A1 extends Thread {
    S15A1(String name, int priority) {
        setName(name);
        setPriority(priority);
    }
    public void run() {
        System.out.println("Thread Name: " + getName() + ", Priority: " + getPriority());
    }
    public static void main(String[] args) throws InterruptedException {
        S15A1 t1 = new S15A1("LowPriority", Thread.MIN_PRIORITY);     // Priority 1
        S15A1 t2 = new S15A1("NormalPriority", Thread.NORM_PRIORITY); // Priority 5
        S15A1 t3 = new S15A1("HighPriority", Thread.MAX_PRIORITY);    // Priority 10

        t3.start(); // High Priority
        t3.join();  // Waits for t3 to finish
        
        t2.start(); // Normal Priority
        t2.join();  // Waits for t2 to finish
        
        t1.start(); // Low Priority
        t1.join();  // Waits for t1 to finish
    }
}

