package com.userclaim.services;

import org.springframework.stereotype.Service;

import com.userclaim.model.UserClaim;

@Service
public class UserClaimServiceImpl implements UserClaimService {

    @Override
    public void processUserClaim(UserClaim userClaim) {
        // Business logic for processing the user claim goes here
        // For example, saving the user claim to a database or performing calculations
        System.out.println("Processing user claim: " + userClaim.getName() + ", amount: " + userClaim.getAmount());
    }
}

