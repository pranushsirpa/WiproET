package com.example.realtimeclaimstatus.repository;

import com.example.realtimeclaimstatus.model.Claim;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClaimRepository extends ReactiveCrudRepository<Claim, Long> {
}
