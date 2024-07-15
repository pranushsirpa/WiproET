package com.example.claimpolicies.controller;

import com.example.claimpolicies.model.Policy;
import com.example.claimpolicies.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public Policy createPolicy(@RequestBody Policy policy) {
        return policyService.savePolicy(policy);
    }

    @PutMapping("/{id}")
    public Policy updatePolicy(@PathVariable Long id, @RequestBody Policy policy) {
        policy.setId(id);
        return policyService.updatePolicy(policy);
    }

    @GetMapping("/{id}")
    public Policy getPolicyById(@PathVariable Long id) {
        return policyService.getPolicyById(id);
    }

    @DeleteMapping("/{id}")
    public void deletePolicy(@PathVariable Long id) {
        policyService.deletePolicy(id);
    }

    @GetMapping
    public List<Policy> getAllPolicies() {
        return policyService.getAllPolicies();
    }
}
