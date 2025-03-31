import java.util.Random;
class S13A2 extends Thread{
    private String threadName;

    public S13A2(String name){
        this.threadName = name;
    }

    public void run(){
        System.out.println(threadName + " is created");
        Random random  = new Random();
        int sleepTime = random.nextInt(5000);
        System.out.println(threadName + " is going to sleep for "+sleepTime+" milliseconds");
        try{
            Thread.sleep(sleepTime);
        }catch(InterruptedException e){
            System.out.println(e);
        }
        System.out.println(threadName + " is dead");
    }

    public static void main(String[] args){
        S13A2 t1 = new S13A2("Thread 1");
        S13A2 t2 = new S13A2("Thread 2");
        S13A2 t3 = new S13A2("Thread 3");

        t1.start();
        t2.start();
        t3.start();
    }
}
