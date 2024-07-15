package com.example.claimpolicies.service;


import com.example.claimpolicies.model.Claim;
import com.example.claimpolicies.repository.ClaimRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimService {

    @Autowired
    private ClaimRepository claimRepository;

    public Claim saveClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public Claim updateClaim(Claim claim) {
        return claimRepository.save(claim);
    }

    public Claim getClaimById(Long id) {
        return claimRepository.findById(id).orElse(null);
    }

    public void deleteClaim(Long id) {
        claimRepository.deleteById(id);
    }

    public List<Claim> getAllClaims() {
        return claimRepository.findAll();
    }
}
