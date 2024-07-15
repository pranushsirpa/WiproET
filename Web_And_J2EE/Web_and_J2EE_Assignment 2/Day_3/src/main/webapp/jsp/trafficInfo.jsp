<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Traffic Information</title>
</head>
<body>
    <h1>Real-Time Traffic Information</h1>
    <% 
        com.example.bean.TrafficData trafficData = (com.example.bean.TrafficData) request.getAttribute("trafficData");
        if (trafficData != null) {
    %>
        <p>Location: <%= trafficData.getLocation() %></p>
        <p>Traffic Level: <%= trafficData.getTrafficLevel() %></p>
    <% } %>
    <form action="userQuery" method="post">
        <h2>Enter your preferences:</h2>
        <label for="preferredRoute">Preferred Route:</label>
        <input type="text" id="preferredRoute" name="preferredRoute"><br>
        <label for="avoidAreas">Avoid Areas:</label>
        <input type="text" id="avoidAreas" name="avoidAreas"><br>
        <input type="submit" value="Get Alternative Routes">
    </form>
</body>
</html>
