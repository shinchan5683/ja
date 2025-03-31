import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class S15A2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        int count = 1;
        Cookie[] cookies = req.getCookies();
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    count = Integer.parseInt(c.getValue()) + 1;
                }
            }
        }

        res.addCookie(new Cookie("visitCount", String.valueOf(count)));

        out.println(count == 1 ? "<h3>Welcome! This is your first visit.</h3>" 
                               : "<h3>You have visited this page " + count + " times.</h3>");
    }
}

