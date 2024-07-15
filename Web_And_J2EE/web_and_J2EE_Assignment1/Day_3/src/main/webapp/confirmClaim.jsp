 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.policy.ClaimBean" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Confirm Claim</title>
</head>
<body>
    <h2>Confirm Your Claim</h2>
    <%
        ClaimBean claim = (ClaimBean) request.getAttribute("claim");
    %>
    <p>Policy Number: <%= claim.getPolicyNumber() %></p>
    <p>Claim Type: <%= claim.getClaimType() %></p>
    <p>Claim Amount: $<%= claim.getClaimAmount() %></p>
    <form action="finalizeClaim" method="post">
        <input type="submit" value="Confirm">
    </form>
</body>
</html>
