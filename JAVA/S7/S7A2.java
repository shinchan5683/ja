import java.sql.*;
public class S7A2 {
    public static void main(String[] args) {
        // PostgreSQL connection details
        String url = "jdbc:postgresql://localhost:5432/product"; // Ensure this database exists in PostgreSQL
        String user = "postgres"; // Default PostgreSQL user
        String password = "root"; // Change to your PostgreSQL password

        try (Connection con = DriverManager.getConnection(url, user, password);
             Statement stmt = con.createStatement()) {

            // i. Create Product table (if not exists)
            String createTableSQL = "CREATE TABLE IF NOT EXISTS Product (" +
                                    "Pid SERIAL PRIMARY KEY, " +  // SERIAL handles auto-increment
                                    "Pname VARCHAR(50), " +
                                    "Price DECIMAL(10,2))";
            stmt.executeUpdate(createTableSQL);

            // ii. Insert records into Product table (handling duplicate Pid)
            String insertSQL = "INSERT INTO Product (Pid, Pname, Price) VALUES " +
                               "(1, 'Product1', 100.00), " +
                               "(2, 'Product2', 200.00), " +
                               "(3, 'Product3', 300.00), " +
                               "(4, 'Product4', 400.00), " +
                               "(5, 'Product5', 500.00) " +
                               "ON CONFLICT (Pid) DO NOTHING";  // Prevents errors if records exist
            stmt.executeUpdate(insertSQL);

            // iii. Retrieve and display all records from Product table
            String selectSQL = "SELECT * FROM Product";
            ResultSet rs = stmt.executeQuery(selectSQL);

            while (rs.next()) {
                int pid = rs.getInt("Pid");
                String pname = rs.getString("Pname");
                double price = rs.getDouble("Price");
                System.out.println("Pid: " + pid + ", Pname: " + pname + ", Price: " + price);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

