package com.example.claimservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClaimController {
    @GetMapping("/claims")
    public String getClaims() {
        return "Claim data";
    }
}
