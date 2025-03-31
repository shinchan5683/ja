import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class S25A2 extends JFrame {
    private JTextField queryField;
    private JButton createBtn, alterBtn, dropBtn;
    private Connection con;

    public S25A2() {
        setTitle("DDL Query Executor");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        queryField = new JTextField(25);
        createBtn = new JButton("Create Table");
        alterBtn = new JButton("Alter Table");
        dropBtn = new JButton("Drop Table");

        add(new JLabel("Type Your DDL Query Here"));
        add(queryField);
        add(createBtn);
        add(alterBtn);
        add(dropBtn);

        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "root");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database Connection Failed!");
        }

        ActionListener executeDDL = e -> {
            try (Statement stmt = con.createStatement()) {
                stmt.executeUpdate(queryField.getText());
                JOptionPane.showMessageDialog(this, "Query Executed Successfully!");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            }
        };

        createBtn.addActionListener(executeDDL);
        alterBtn.addActionListener(executeDDL);
        dropBtn.addActionListener(executeDDL);

        setVisible(true);
    }

    public static void main(String[] args) {
        new S25A2();
    }
}

