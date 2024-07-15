package com.policy;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class ClaimFinalizationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Finalize claim process
        // This can include saving the claim to a database, etc.
        
        // For now, just redirect to a thank you page
        response.sendRedirect("thank.jsp");
    }
}

