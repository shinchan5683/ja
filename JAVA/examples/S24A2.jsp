<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String user = request.getParameter("username");
    String pass = request.getParameter("password");

    if (user != null && pass != null && user.equals(pass)) {
        response.sendRedirect("login.html");
    } else {
        response.sendRedirect("error.html");
    }
%>

