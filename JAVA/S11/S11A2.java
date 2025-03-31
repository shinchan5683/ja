import java.sql.*;
public class S11A2{
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/product";
        String username = "postgres";
        String password = "root";

        try(Connection con = DriverManager.getConnection(url,username,password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Donar")){

                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                System.out.println("Column Information:");
                for(int i=1;i<=columnCount;i++){
                    System.out.println("Column "+i+":");
                    System.out.println("Name:"+rsmd.getColumnName(i));
                    System.out.println("Type:"+rsmd.getColumnTypeName(i));
                    System.out.println("Size:"+rsmd.getColumnDisplaySize(i));
                    System.out.println("Is Nullabel:"+rsmd.isNullable(i));
                    System.out.println();
                }

        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
