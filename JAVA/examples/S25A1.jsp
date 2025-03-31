<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Voter Eligibility</title></head>
<body>

<% if (request.getParameter("name") == null) { %>
    <form method="post">
        Name: <input type="text" name="name" required><br>
        Age: <input type="number" name="age" required><br>
        <input type="submit" value="Check Eligibility">
    </form>
<% } else { 
    String name = request.getParameter("name");
    int age = Integer.parseInt(request.getParameter("age"));
%>
    <h2 style="color:<%= (age >= 18) ? "green" : "red" %>;">
        <%= name %> is <%= (age >= 18) ? "Eligible" : "Not Eligible" %> for Voting.
    </h2>
<% } %>

</body>
</html>

