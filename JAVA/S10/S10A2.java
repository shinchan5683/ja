import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class S10A2 extends JFrame {
    private JTextField rnoField = new JTextField(), snameField = new JTextField(), perField = new JTextField();

    public S10A2() {
        setTitle("Student Record");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));
        add(new JLabel("Roll No:")); add(rnoField);
        add(new JLabel("Student Name:")); add(snameField);
        add(new JLabel("Percentage:")); add(perField);

        JButton fetchButton = new JButton("Fetch Record");
        fetchButton.addActionListener(e -> fetchFirstRecord());
        add(fetchButton);
        setVisible(true);
    }

    private void fetchFirstRecord() {
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "root");
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Student")) {
            if (rs.next()) {
                rnoField.setText(rs.getString(1));
                snameField.setText(rs.getString(2));
                perField.setText(rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new S10A2();
    }
}

