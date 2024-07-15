package com.example.servlet;

import com.example.bean.TrafficData;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class TrafficDataServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Simulate fetching real-time traffic data
        TrafficData trafficData = new TrafficData("Main Street", 75);

        // Store the traffic data in the request attributes
        request.setAttribute("trafficData", trafficData);

        // Forward to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/trafficInfo.jsp");
        dispatcher.forward(request, response);
    }
}
