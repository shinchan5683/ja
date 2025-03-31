import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S27A2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.setMaxInactiveInterval(300); // Set session timeout to 5 minutes (300 seconds)

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println("<h3>Session timeout set to 5 minutes!</h3>");
    }
}

