package com.example.claimpolicies.service;

import com.example.claimpolicies.model.Policy;
import com.example.claimpolicies.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    public Policy savePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy updatePolicy(Policy policy) {
        return policyRepository.save(policy);
    }

    public Policy getPolicyById(Long id) {
        return policyRepository.findById(id).orElse(null);
    }

    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }

    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
}
