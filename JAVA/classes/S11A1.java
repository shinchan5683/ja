import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class S11A1 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        String custNo = req.getParameter("custNo");

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/yourDB", "root", "password");
             PreparedStatement ps = con.prepareStatement("SELECT * FROM customer WHERE cust_no=?")) {

            ps.setString(1, custNo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                out.println("<h3>Customer Found:</h3>");
                out.println("<p>Customer Number: " + rs.getInt("cust_no") + "</p>");
                out.println("<p>Name: " + rs.getString("name") + "</p>");
                out.println("<p>Email: " + rs.getString("email") + "</p>");
            } else {
                out.println("<h3 style='color:red;'>Customer Not Found</h3>");
            }
        } catch (Exception e) {
            out.println("<h3 style='color:red;'>Error: " + e.getMessage() + "</h3>");
        }
    }
}

