import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class A1 extends JFrame implements ActionListener{
  JPanel jp1,jp2;
  JLabel jl1,jl2,jl3,jl4;
  JTextField jtf1,jtf2,jtf3,jtf4;
  JButton jb1;
  Connection con;
  Statement stmt;
  String url="jdbc:postgresql://localhost:5432/product";
  String usr="postgres";
  String pwd="root";
  A1(){
    try{
      con=DriverManager.getConnection(url,usr,pwd);
      stmt=con.createStatement();
      setTitle("Employee Details");
      setSize(400,400);
      setLayout(new BorderLayout());
      jp1 = new JPanel();
      jp1.setLayout(new GridLayout(4,2));
      jl1 = new JLabel("Employee No");
      jtf1 = new JTextField(20);
      jl2 = new JLabel("Employee Name");
      jtf2 = new JTextField(20);
      jl3 = new JLabel("Designation");
      jtf3 = new JTextField(20);
      jl4 = new JLabel("Salary");
      jtf4 = new JTextField(20);
      jb1 = new JButton("Submit");
      jp1.add(jl1);
      jp1.add(jtf1);
      jp1.add(jl2);
      jp1.add(jtf2);
      jp1.add(jl3);
      jp1.add(jtf3);
      jp1.add(jl4);
      jp1.add(jtf4);
      add(jp1,BorderLayout.CENTER);
      add(jb1, BorderLayout.SOUTH); 
      setVisible(true);
      jb1.addActionListener(this);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      }catch(Exception e){
      System.out.println(e);
      }
    }
      public void actionPerformed(ActionEvent ae){
        try{
          if(ae.getSource()==jb1){
            String eno=jtf1.getText();
            String ename=jtf2.getText();
            String desig=jtf3.getText();
            String sal=jtf4.getText();
            stmt.executeUpdate("Insert into Employee values('"+eno+"','"+ename+"','"+desig+"','"+sal+"')");
            System.out.println("Record Inserted");
          }
        }catch(Exception e){
          System.out.println(e);
        }
      }
      public static void main(String[] args){
        new A1();
      }
    }
