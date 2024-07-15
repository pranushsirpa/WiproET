package com.policy;


import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class ClaimSubmissionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Retrieve form data
        String policyNumber = request.getParameter("policyNumber");
        String claimType = request.getParameter("claimType");
        double claimAmount = Double.parseDouble(request.getParameter("claimAmount"));
        
        // Create a new ClaimBean
        ClaimBean claim = new ClaimBean();
        claim.setPolicyNumber(policyNumber);
        claim.setClaimType(claimType);
        claim.setClaimAmount(claimAmount);
        
        // Store the claim in the request
        request.setAttribute("claim", claim);
        
        // Forward to the confirmation page
        RequestDispatcher dispatcher = request.getRequestDispatcher("confirmClaim.jsp");
        dispatcher.forward(request, response);
    }
}
