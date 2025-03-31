import java.sql.*;
class S29A1{
    public static void main(String[] args){
        Connection con;
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData rmd;
        int n;
        try{
            //Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product","postgres","root");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from Donor");
            rmd = rs.getMetaData();

            n = rmd.getColumnCount();
            System.out.println("Number of columns in DONOR table: "+n);

            System.out.println("No\tName\tLabel\tType\tDisplaySize\tReadOnly\tWritable\tNULL");
            for(int i=1;i<=n;i++){
                System.out.println(i+"\t"+rmd.getColumnName(i)+"\t"+rmd.getColumnLabel(i)+"\t"+rmd.getColumnTypeName(i)+"\t\t"
                                    +rmd.getColumnDisplaySize(i)+"\t"+rmd.isReadOnly(i)+"\t\t"+rmd.isWritable(i)+"\t\t"+rmd.isNullable(i));

            }
        }catch(SQLException sqle){
            System.out.println("SQL Exception:"+sqle);

        }catch(Exception e){
            System.out.println("Exception"+e);
        }     
    
    }
}


/*
import java.awt.*;
class S29A1 extends Frame {
    
    S29A1() {
        setTitle("Donor Table");
        setSize(600, 300);
        setLayout(new GridLayout(6, 5)); // 6 rows, 5 columns

        // Column Headers
        String[] headers = { "ID", "Name", "Age", "Blood Group", "City" };
        for (String header : headers) add(new Label(header, Label.CENTER));

        // Real-world donor data
        String[][] data = {
            {"101", "Amit Sharma", "28", "O+", "Mumbai"},
            {"102", "Neha Singh", "24", "A-", "Delhi"},
            {"103", "Rahul Verma", "32", "B+", "Bangalore"},
            {"104", "Priya Das", "29", "AB+", "Kolkata"},
            {"105", "Vikas Mehta", "35", "O-", "Chennai"}
        };
        
        for (String[] row : data) {
            for (String cell : row) add(new Label(cell, Label.CENTER));
        }

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new S29A1();
    }
}
*/
