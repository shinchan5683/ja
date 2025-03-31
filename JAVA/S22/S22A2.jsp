<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.time.LocalTime" %>
<html>
<head><title>Greeting User</title></head>
<body>
    <form method="post">
        Enter Your Name: <input type="text" name="username" required>
        <input type="submit" value="Greet Me">
    </form>

    <% 
        String name = request.getParameter("username");
        if (name != null) {
            int hour = LocalTime.now().getHour();
            String greeting = (hour < 12) ? "Good Morning" : (hour < 18) ? "Good Afternoon" : "Good Evening";
    %>
        <h2><%= greeting + ", " + name + "!" %></h2>
    <% } %>
</body>
</html>

