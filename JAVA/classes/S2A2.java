import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class S2A2 extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        ServletContext context = getServletContext();
        
        out.println("<html><body><h2>Request & Server Info</h2>");
        out.println("<b>Client IP:</b> " + req.getRemoteAddr() + "<br>");
        out.println("<b>Browser:</b> " + req.getHeader("User-Agent") + "<br>");
        out.println("<b>Server OS:</b> " + System.getProperty("os.name") + "<br>");
        out.println("<b>Loaded Servlets:</b> " + context.getServletRegistrations().keySet() + "<br>");
        out.println("</body></html>");
    }
}

