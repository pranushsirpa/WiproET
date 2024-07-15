package com.policy.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.policy.model.Policy;
import com.policy.repository.PolicyRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PolicyServiceImpl implements PolicyService {

    @Autowired
    private PolicyRepository policyRepository;

    @Override
    public void savePolicy(Policy policy) {
        policyRepository.save(policy);
    }

    @Override
    public Policy getPolicyById(Long id) {
        Optional<Policy> optionalPolicy = policyRepository.findById(id);
        return optionalPolicy.orElse(null);
    }

    @Override
    public void updatePolicy(Policy policy) {
        policyRepository.save(policy);
    }

    @Override
    public void deletePolicy(Long id) {
        policyRepository.deleteById(id);
    }

    @Override
    public List<Policy> getAllPolicies() {
        return policyRepository.findAll();
    }
}

