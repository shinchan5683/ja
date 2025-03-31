//Write a java program to simulate traffic signal using threads.  

import java.util.*;

class S6A2 implements Runnable {
    private String[] signals = {"Red", "Green", "Yellow"};
    private int index = 0;

    public void run() {
        try {
            while (true) {
                System.out.println("Signal: " + signals[index]);
                switch (signals[index]) {
                    case "Red":
                        Thread.sleep(5000); // Red for 5 seconds
                        break;
                    case "Green":
                        Thread.sleep(5000); // Green for 5 seconds
                        break;
                    case "Yellow":
                        Thread.sleep(2000); // Yellow for 2 seconds
                        break;
                }
                index = (index + 1) % signals.length;
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        S6A2 signal = new S6A2();
        Thread thread = new Thread(signal);
        thread.start();
    }
}