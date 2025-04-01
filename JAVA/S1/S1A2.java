import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class EmployeeForm extends JFrame implements ActionListener {
    private JTextField jtf1, jtf2, jtf3, jtf4;
    private JButton jb1;
    private Connection con;
    private Statement stmt;

    EmployeeForm() {
        try {
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "root");
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println(e);
        }

        setTitle("Employee Details");
        setSize(400, 300);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel jp1 = new JPanel(new GridLayout(4, 2));
        String[] labels = {"Employee No", "Employee Name", "Designation", "Salary"};
        JTextField[] fields = {jtf1 = new JTextField(), jtf2 = new JTextField(), jtf3 = new JTextField(), jtf4 = new JTextField()};
        
        for (int i = 0; i < labels.length; i++) {
            jp1.add(new JLabel(labels[i]));
            jp1.add(fields[i]);
        }

        jb1 = new JButton("Submit");
        jb1.addActionListener(this);
        
        add(jp1, BorderLayout.CENTER);
        add(jb1, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            stmt.executeUpdate("INSERT INTO Employee VALUES ('" + jtf1.getText() + "', '" + jtf2.getText() + "', '" + jtf3.getText() + "', '" + jtf4.getText() + "')");
            System.out.println("Record Inserted");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new EmployeeForm();
    }
}
