import javax.swing.*;
import java.awt.*;
public class S24A1 extends JFrame {
    private String text = "   Scrolling Text Demo   ";
    private JLabel label = new JLabel(text, JLabel.CENTER);

    public S24A1() {
        setTitle("Text Scroller");
        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(label, BorderLayout.CENTER);
        new Timer(200, e -> scrollText()).start();
        setVisible(true);
    }

    private void scrollText() {
        text = text.substring(1) + text.charAt(0);
        label.setText(text);
    }

    public static void main(String[] args) {
        new S24A1();
    }
}

