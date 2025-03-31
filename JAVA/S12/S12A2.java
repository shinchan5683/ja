import java.sql.*;
import javax.swing.*;
import java.awt.*;

public class S12A2 extends JFrame{
    private JTable table;

    public S12A2(){
        setTitle("Project Details");
        setSize(800,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columnNames = {"Project ID","Project Name","Project Description","Project Status"};
        Object[][] data = fetchProjectData();

        table = new JTable(data, columnNames);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setVisible(true);
    }

    private Object[][] fetchProjectData(){
        String url = "jdbc:postgresql://localhost:5432/product";
        String username = "postgres";
        String password = "root";

        try(Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * From Project")){
                
                rs.last();
                int rowCount = rs.getRow();
                rs.beforeFirst();

                Object[][] data = new Object[rowCount][4];
                int rowIndex = 0;

                while(rs.next()){
                    data[rowIndex][0] = rs.getInt(1);
                    data[rowIndex][1] = rs.getString(2);
                    data[rowIndex][2] = rs.getString(3);
                    data[rowIndex][3] = rs.getString(4);
                    rowIndex++;
                }
                return data;
            }catch(SQLException e){
                System.out.println(e);
                return new Object[0][0];
            }
    }
    
    public static void main(String[] args){
        new S12A2();
    }
}
