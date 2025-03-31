<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.text.NumberFormat" %>
<form method="post">
    Enter a number: <input type="number" name="num" required>
    <input type="submit" value="Convert">
</form>

<% 
    String[] words = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String numStr = request.getParameter("num");
    if (numStr != null) {
        int num = Integer.parseInt(numStr);
        String result = "";
        for (char c : numStr.toCharArray()) result += words[c - '0'] + " ";
%>
    <h3 style="color:red;"> <%= num %> - <%= result.trim() %> </h3>
<% } %>

