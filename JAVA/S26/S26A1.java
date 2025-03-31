import java.sql.*;
public class S26A1 {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java S26A1 <Employee_ID>");
            return;
        }

        int empId = Integer.parseInt(args[0]);
        try (Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/product", "postgres", "root");
             PreparedStatement ps = con.prepareStatement("DELETE FROM Employee WHERE ENo = ?")) {
             
            ps.setInt(1, empId);
            int rows = ps.executeUpdate();
            System.out.println(rows > 0 ? "Employee Deleted Successfully" : "Employee Not Found");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

