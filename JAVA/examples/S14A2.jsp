<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form method="post">
    Enter a number: <input type="number" name="num" required>
    <input type="submit" value="Calculate">
</form>

<% 
    String numStr = request.getParameter("num");
    if (numStr != null) {
        int num = Integer.parseInt(numStr);
        int last = num % 10, first = Integer.parseInt(numStr.substring(0, 1));
%>
    <h3 style="color:red; font-size:18px;">Sum of first and last digit: <%= first + last %></h3>
<% } %>

