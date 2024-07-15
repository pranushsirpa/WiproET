package com.example.realtimeclaimstatus.service;

import com.example.realtimeclaimstatus.model.Claim;
import com.example.realtimeclaimstatus.repository.ClaimRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClaimService {

    private final ClaimRepository claimRepository;

    public ClaimService(ClaimRepository claimRepository) {
        this.claimRepository = claimRepository;
    }

    public Flux<Claim> getAllClaims() {
        return claimRepository.findAll();
    }

    public Mono<Claim> getClaimById(Long id) {
        return claimRepository.findById(id);
    }

    public Mono<Claim> updateClaimStatus(Long id, String status) {
        return claimRepository.findById(id)
                .flatMap(claim -> {
                    claim.setStatus(status);
                    return claimRepository.save(claim);
                });
    }
}
