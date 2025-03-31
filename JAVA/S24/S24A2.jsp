<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    if (user != null && pass != null && user.equals(pass)) {
        response.sendRedirect("Login.html");
    } else {
        response.sendRedirect("Error.html");
    }
%>

