package com.example.claimpolicies.controller;


import com.example.claimpolicies.model.Claim;
import com.example.claimpolicies.service.ClaimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    @PostMapping
    public Claim createClaim(@RequestBody Claim claim) {
        return claimService.saveClaim(claim);
    }

    @PutMapping("/{id}")
    public Claim updateClaim(@PathVariable Long id, @RequestBody Claim claim) {
        claim.setId(id);
        return claimService.updateClaim(claim);
    }

    @GetMapping("/{id}")
    public Claim getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteClaim(@PathVariable Long id) {
        claimService.deleteClaim(id);
    }

    @GetMapping
    public List<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }
}
