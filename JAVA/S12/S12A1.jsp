<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head><title>Perfect Number Check</title></head>
<body>
    <form method="post">
        Enter Number: <input type="number" name="num" required>
        <button type="submit">Check</button>
    </form>

    <%
        String numStr = request.getParameter("num");
        if (numStr != null) {
            int num = Integer.parseInt(numStr), sum = 0;
            for (int i = 1; i <= num / 2; i++) if (num % i == 0) sum += i;
            out.println("<h3 style='color:" + (sum == num ? "green" : "red") + ";'>" + num + 
                        (sum == num ? " is a Perfect Number" : " is NOT a Perfect Number") + "</h3>");
        }
    %>
</body>
</html>

