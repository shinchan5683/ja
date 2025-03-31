import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class S20A2 extends JFrame implements Runnable{
    JLabel imageLabel;
    Thread t;
    boolean flag;

    public S20A2(){
        setSize(600,400);
        setLocationRelativeTo(null);
        setTitle("Blinking Image");

        ImageIcon icon=new ImageIcon("images.jpeg");
        imageLabel=new JLabel(icon);
        add(imageLabel,BorderLayout.CENTER);

        t=new Thread(this);
        t.start();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void run(){
        while(true){
            try{
                flag = !flag;
                imageLabel.setVisible(flag);
                Thread.sleep(100);
            }catch(InterruptedException ie){
                System.out.println(ie);
            }
        }
    }

    public static void main(String[] args){
        new S20A2();
    }
}
