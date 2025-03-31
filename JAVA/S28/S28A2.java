import java.util.*;
class S28A2 extends Thread {
    public void run() {
        System.out.println("Current Thread: " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        for (int i = 1; i <= 3; i++) 
            new S28A2().start();
    }
}

