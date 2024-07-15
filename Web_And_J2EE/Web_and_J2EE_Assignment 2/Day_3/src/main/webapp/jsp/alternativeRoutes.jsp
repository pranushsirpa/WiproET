<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Alternative Routes</title>
</head>
<body>
    <h1>Alternative Routes</h1>
    <%
        com.example.bean.UserPreferences userPreferences = (com.example.bean.UserPreferences) request.getAttribute("userPreferences");
        if (userPreferences != null) {
    %>
        <p>Preferred Route: <%= userPreferences.getPreferredRoute() %></p>
        <p>Avoid Areas: <%= userPreferences.getAvoidAreas() %></p>
    <% } %>
    <!-- Display alternative routes based on user preferences -->
</body>
</html>
