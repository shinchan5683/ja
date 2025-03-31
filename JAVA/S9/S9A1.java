import javax.swing.*;
import java.awt.*;

public class S9A1 extends JPanel implements Runnable {
    int y = 50, direction = 1;
    boolean running = false;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(100, y, 30, 30);
    }

    public void run() {
        while (running) {
            y += 5 * direction;
            if (y <= 0 || y >= getHeight() - 30) direction *= -1;
            repaint();
            try { Thread.sleep(30); } catch (Exception ignored) {}
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ball Mover");
        S9A1 panel = new S9A1();
        JButton startBtn = new JButton("Start");

        startBtn.addActionListener(e -> {
            if (!panel.running) { panel.running = true; new Thread(panel).start(); }
        });

        frame.add(panel);
        frame.add(startBtn, BorderLayout.SOUTH);
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

