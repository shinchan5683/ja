<%@ page contentType="text/html" language="java" import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Quiz</title>
</head>
<body>
    <%
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String url = "jdbc:mysql://localhost:3306/your_database";
        String user = "your_username";
        String password = "your_password";
        int questionId = 1;
        int score = 0;

        if (request.getParameter("questionId") != null) {
            questionId = Integer.parseInt(request.getParameter("questionId"));
            score = Integer.parseInt(request.getParameter("score"));
            String selectedOption = request.getParameter("option");
            String correctOption = request.getParameter("correctOption");

            if (selectedOption != null && selectedOption.equals(correctOption)) {
                score++;
            }
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM questions WHERE id = " + questionId);

            if (rs.next()) {
    %>
                <form action="S5A2.jsp" method="post">
                    <h3><%= rs.getString("question") %></h3>
                    <input type="radio" name="option" value="1"> <%= rs.getString("option1") %><br>
                    <input type="radio" name="option" value="2"> <%= rs.getString("option2") %><br>
                    <input type="radio" name="option" value="3"> <%= rs.getString("option3") %><br>
                    <input type="radio" name="option" value="4"> <%= rs.getString("option4") %><br>
                    <input type="hidden" name="questionId" value="<%= questionId + 1 %>">
                    <input type="hidden" name="score" value="<%= score %>">
                    <input type="hidden" name="correctOption" value="<%= rs.getString("correctOption") %>">
                    <input type="submit" value="Next">
                </form>
    <%
            } else {
    %>
                <h3>Your total score is: <%= score %></h3>
    <%
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { 
                if (rs != null)
                     rs.close(); 
            } catch (SQLException e) { 
                e.printStackTrace(); 
            }

            try { 
                if (stmt != null) 
                    stmt.close(); 
                } catch (SQLException e) { 
                    e.printStackTrace(); 
                }
            try { 
                if (con != null) 
                    con.close(); 
                } catch (SQLException e) { 
                    e.printStackTrace(); 
            }
        }
    %>
</body>
</html>
