package com.example.servlet;

import com.example.bean.UserPreferences;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UserQueryServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get user preferences from the request
        String preferredRoute = request.getParameter("preferredRoute");
        String avoidAreas = request.getParameter("avoidAreas");

        // Store the user preferences in a bean
        UserPreferences userPreferences = new UserPreferences(preferredRoute, avoidAreas);

        // Store the preferences in the request attributes
        request.setAttribute("userPreferences", userPreferences);

        // Forward to the JSP page to display alternative routes
        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/alternativeRoutes.jsp");
        dispatcher.forward(request, response);
    }
}
