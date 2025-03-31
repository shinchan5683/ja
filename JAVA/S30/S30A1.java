import java.util.*;
class S30A1 {
    int a, b;
    synchronized void accept() 
    {
        a = new Random().nextInt(100);
        b = new Random().nextInt(100);
        System.out.println("Generated: " + a + ", " + b);
        notifyAll();
    }

    synchronized void process(String msg) throws InterruptedException
    {
        wait();
        System.out.println(msg + (msg.equals("Sum: ") ? (a + b) : a + ", " + b));
    }

    public static void main(String[] args) throws InterruptedException 
    {
        S30A1 ob = new S30A1();

        new Thread(() -> { try { ob.process("Numbers: "); } catch (Exception e) {} }).start();
        new Thread(() -> { try { ob.process("Sum: "); } catch (Exception e) {} }).start();

        Thread.sleep(500);  
        ob.accept();
    }
}


