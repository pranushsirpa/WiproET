package com.policy.service;

import com.policy.model.Policy;

import java.util.List;

public interface PolicyService {
    void savePolicy(Policy policy);
    Policy getPolicyById(Long id);
    void updatePolicy(Policy policy);
    void deletePolicy(Long id);
    List<Policy> getAllPolicies();
}
