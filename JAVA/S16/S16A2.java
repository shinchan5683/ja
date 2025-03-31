import java.sql.*;
public class S16A2 {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/product"; 
        String user = "postgres", pass = "root";

        try (Connection con = DriverManager.getConnection(url, user, pass)) {
            PreparedStatement insertStmt = con.prepareStatement("INSERT INTO Teacher VALUES (?, ?, ?)");
            int[][] data = {{1, "Alice", "JAVA"}, {2, "Bob", "DBMS"}, {3, "Charlie", "JAVA"},
                            {4, "David", "OS"}, {5, "Eve", "JAVA"}};

            for (int[] d : data) {
                insertStmt.setInt(1, d[0]);
                insertStmt.setString(2, d[1]);
                insertStmt.setString(3, d[2]);
                insertStmt.executeUpdate();
            }

            PreparedStatement fetchStmt = con.prepareStatement("SELECT * FROM Teacher WHERE Subject = ?");
            fetchStmt.setString(1, "JAVA");
            ResultSet rs = fetchStmt.executeQuery();

            while (rs.next()) 
                System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

