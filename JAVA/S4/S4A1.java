import javax.swing.*;
import java.awt.*;

public class S4A1 extends JFrame implements Runnable {
    private JLabel label = new JLabel("Laxman Andhale", SwingConstants.CENTER);

    public S4A1() {
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label);
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        new Thread(this).start();
    }

    public void run() {
        try {
            while (true) {
                label.setVisible(!label.isVisible());
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new S4A1();
    }
}
