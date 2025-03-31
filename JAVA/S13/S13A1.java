import java.sql.*;
public class S13A1{
    public static void main(String[] args){
        String url = "jdbc:postgresql://localhost:5432/product";
        String username = "postgres";
        String password = "root";

        try(Connection con = DriverManager.getConnection(url,username,password)){
            DatabaseMetaData dbmd = con.getMetaData();

            System.out.println("Driver Product Name:"+dbmd.getDatabaseProductName());
            System.out.println("Driver Product Version:"+dbmd.getDatabaseProductVersion());
            System.out.println("Driver Name:"+dbmd.getDriverName());
            System.out.println("Driver Version:"+dbmd.getDriverVersion());

            ResultSet tables = dbmd.getTables(null,null,null,new String[]{"TABLE"});
            System.out.println("\nTables in the database:");
            while(tables.next()){
                System.out.println(tables.getString("TABLE_NAME"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
