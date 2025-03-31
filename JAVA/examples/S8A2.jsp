<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<form method="post">
    Enter a number: <input type="number" name="num" required>
    <input type="submit" value="Check">
</form>

<% 
    String numStr = request.getParameter("num");
    if (numStr != null) {
        int num = Integer.parseInt(numStr);
        boolean isPrime = num > 1 && java.util.stream.IntStream.range(2, (int) Math.sqrt(num) + 1).noneMatch(i -> num % i == 0);
%>
    <h3 style="color:red;">The number <%= num %> is <%= isPrime ? "Prime" : "Not Prime" %>.</h3>
<% } %>

