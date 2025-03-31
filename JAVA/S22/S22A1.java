import java.sql.*;
import java.util.Scanner;

public class S22A1{
    private static final String url = "jdbc:postgresql://localhost:5432/product";
    private static final String username = "postgres";
    private static final String password = "root";

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        try(Connection con = DriverManager.getConnection(url,username,password)){
            while(true){
                System.out.println("Menu:");
                System.out.println("1.Insert");
                System.out.println("2.Update");
                System.out.println("3.Dispaly");
                System.out.println("4.Exit");
                System.out.println("Enter your choice:");
                int choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                    case 1:insertEmployee(con,sc);
                           break;
                    case 2:updateEmployee(con,sc);
                           break;
                    case 3:displayEmployees(con);
                           break;
                    case 4:System.out.println("Exiting...");
                           return;
                    default:System.out.println("Invalid choice. Please try again");
                }
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }

    private static void insertEmployee(Connection con,Scanner sc) throws SQLException{
        System.out.println("Enter Employee Number:");
        int eno = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Employee Name:");
        String ename = sc.nextLine();
        System.out.println("Enter Employee Salary:");
        double salary = sc.nextDouble();

        String insertSQL = "INSERT INTO Employee(ENo,EName,Salary) VALUES(?,?,?)";
        try(PreparedStatement pstmt = con.prepareStatement(insertSQL)){
            pstmt.setInt(1,eno);
            pstmt.setString(2,ename);
            pstmt.setDouble(3,salary);
            pstmt.executeUpdate();
            System.out.println("Employee inserted successfully");
        }
    }

    private static void updateEmployee(Connection con,Scanner sc) throws SQLException{
        System.out.println("Enter Employee Number to update:");
        int eno = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter new Employee Name:");
        String ename = sc.nextLine();
        System.out.println("Enter new Employee Salary:");
        double salary = sc.nextDouble();

        String updateSQL = "UPDATE Employee SET EName=? , Salary=? WHERE ENo=?";
        try(PreparedStatement pstmt = con.prepareStatement(updateSQL)){
            pstmt.setString(1,ename);
            pstmt.setDouble(2,salary);
            pstmt.setInt(3,eno);
            pstmt.executeUpdate();
            System.out.println("Employee Updated Successfully");
        }
    }

    private static void displayEmployees(Connection con) throws SQLException{
        String selectSQL = "SELECT * FROM Employee";
        try(Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(selectSQL)){
                System.out.println("Employee Details:");
                while(rs.next()){
                    int eno = rs.getInt("ENo");
                    String ename = rs.getString("EName");
                    double salary = rs.getDouble("Salary");
                    System.out.println("ENo:"+eno+"EName:"+ename+"Salary:"+salary);
                }
            }
    }
}
