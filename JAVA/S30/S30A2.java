import java.sql.*;
class S30A2 {
    public static void main(String[] args) throws Exception {
        //Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "root");
        Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM Teacher");

        while (rs.next()) 
            System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3));

        rs.last();
        System.out.println("\nLast Record: " + rs.getInt(1) + ", " + rs.getString(2));

        rs.first();
        System.out.println("First Record: " + rs.getInt(1) + ", " + rs.getString(2));

        con.close();
    }
}

