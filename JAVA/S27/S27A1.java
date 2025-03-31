import javax.swing.*;
import java.awt.*;
public class S27A1 {
    public static void main(String[] args) {
        String[][] data = {
            {"101", "ABC College", "Mumbai", "1990"},
            {"102", "XYZ Institute", "Pune", "1985"},
            {"103", "LMN University", "Delhi", "2000"}
        };
        String[] columns = {"CID", "CName", "Address", "Year"};

        JFrame f = new JFrame("College Details");
        f.add(new JScrollPane(new JTable(data, columns)), BorderLayout.CENTER);
        f.setSize(400, 200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}


