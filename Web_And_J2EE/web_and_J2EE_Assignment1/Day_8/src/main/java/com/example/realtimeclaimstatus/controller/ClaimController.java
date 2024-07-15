package com.example.realtimeclaimstatus.controller;

import com.example.realtimeclaimstatus.model.Claim;
import com.example.realtimeclaimstatus.service.ClaimService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/claims")
public class ClaimController {

    private final ClaimService claimService;

    public ClaimController(ClaimService claimService) {
        this.claimService = claimService;
    }

    @GetMapping
    public Flux<Claim> getAllClaims() {
        return claimService.getAllClaims();
    }

    @GetMapping("/{id}")
    public Mono<Claim> getClaimById(@PathVariable Long id) {
        return claimService.getClaimById(id);
    }

    @PutMapping("/{id}/status")
    public Mono<Claim> updateClaimStatus(@PathVariable Long id, @RequestBody String status) {
        return claimService.updateClaimStatus(id, status);
    }
}
