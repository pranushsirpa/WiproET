package com.policy.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.policy.model.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {
}
