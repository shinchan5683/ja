import java.util.*;
class SharedResource {
    private int value;
    private boolean available = false;

    public synchronized void produce(int val) {
        while (available) { 
            try { wait(); } catch (InterruptedException e) {} 
        }
        value = val;
        System.out.println("Produced: " + value);
        available = true;
        notify();
    }

    public synchronized void consume() {
        while (!available) { 
            try { wait(); } catch (InterruptedException e) {} 
        }
        System.out.println("Consumed: " + value);
        available = false;
        notify();
    }
}

class Producer extends Thread {
    SharedResource res;
    Producer(SharedResource res) { this.res = res; }
    public void run() {
        for (int i = 1; i <= 100; i++) {
            res.produce(i);
            try { Thread.sleep(500); } catch (InterruptedException e) {} 
        }
    }
}

class Consumer extends Thread {
    SharedResource res;
    Consumer(SharedResource res) { this.res = res; }
    public void run() {
        for (int i = 1; i <= 100; i++) {
            res.consume();
            try { Thread.sleep(500); } catch (InterruptedException e) {} 
        }
    }
}

public class S21A2 {
    public static void main(String[] args) {
        SharedResource res = new SharedResource();
        new Producer(res).start();
        new Consumer(res).start();
    }
}

