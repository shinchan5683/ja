import javax.swing.*;
import java.awt.*;
public class S17A2 implements Runnable {
    private JTextField textField = new JTextField(10);

    public S17A2() {
        JFrame frame = new JFrame("Counter");
        frame.setSize(250, 120);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        textField.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(textField);

        JButton startButton = new JButton("Start");
        startButton.addActionListener(e -> new Thread(this).start());
        frame.add(startButton);

        frame.setVisible(true);
    }

    public void run() {
        for (int i = 1; i <= 100; i++) {
            textField.setText(i + "");
            try { Thread.sleep(100); } catch (Exception ignored) {}
        }
    }

    public static void main(String[] args) {
        new S17A2();
    }
}

