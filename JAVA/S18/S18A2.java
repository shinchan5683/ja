import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/S18A2")
public class S18A2 extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String seatNo = req.getParameter("seatNo");
        String name = req.getParameter("name");
        String studentClass = req.getParameter("class");
        int totalMarks = Integer.parseInt(req.getParameter("totalMarks"));

        double percentage = (totalMarks / 500.0) * 100;
        String grade = (percentage >= 90) ? "A+" : (percentage >= 80) ? "A" : (percentage >= 70) ? "B" : (percentage >= 60) ? "C" : "D";

        out.println("<h2>Student Details</h2>");
        out.println("<p>Seat No: " + seatNo + "</p>");
        out.println("<p>Name: " + name + "</p>");
        out.println("<p>Class: " + studentClass + "</p>");
        out.println("<p>Total Marks: " + totalMarks + "</p>");
        out.println("<p>Percentage: " + percentage + "%</p>");
        out.println("<p>Grade: " + grade + "</p>");
    }
}


