<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form method="post">
    Enter a string: <input type="text" name="inputString" required>
    <input type="submit" value="Reverse">
</form>

<% 
    String str = request.getParameter("inputString");
    if (str != null) { 
%>
    <h3 style="color:red;">Reversed String: <%= new StringBuilder(str).reverse() %></h3>
<% } %>

