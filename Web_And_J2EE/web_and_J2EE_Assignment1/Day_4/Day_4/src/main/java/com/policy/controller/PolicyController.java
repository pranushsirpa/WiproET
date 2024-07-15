package com.policy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.policy.model.Policy;
import com.policy.service.PolicyService;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping
    public ResponseEntity<Policy> createPolicy(@Valid @RequestBody Policy policy, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        policyService.savePolicy(policy);
        return new ResponseEntity<>(policy, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Policy> getPolicy(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Policy> updatePolicy(@PathVariable Long id, @Valid @RequestBody Policy policyDetails, BindingResult result) {
        if (result.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Policy policy = policyService.getPolicyById(id);
        if (policy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        policy.setName(policyDetails.getName());
        policy.setPolicyNumber(policyDetails.getPolicyNumber());
        policy.setEffectiveDate(policyDetails.getEffectiveDate());
        policyService.updatePolicy(policy);
        return new ResponseEntity<>(policy, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePolicy(@PathVariable Long id) {
        Policy policy = policyService.getPolicyById(id);
        if (policy == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        policyService.deletePolicy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<Policy>> getAllPolicies() {
        List<Policy> policies = policyService.getAllPolicies();
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }
}
