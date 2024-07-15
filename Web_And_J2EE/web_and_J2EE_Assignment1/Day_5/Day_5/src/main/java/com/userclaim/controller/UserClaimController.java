package com.userclaim.controller;



import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.userclaim.model.UserClaim;
import com.userclaim.services.UserClaimService;

@Controller
public class UserClaimController {

    private final UserClaimService userClaimService;

    @Autowired
    public UserClaimController(UserClaimService userClaimService) {
        this.userClaimService = userClaimService;
    }

    @GetMapping("/userclaim")
    public String showUserClaimForm(Model model) {
        model.addAttribute("userClaim", new UserClaim());
        return "userClaimForm";
    }

    @PostMapping("/userclaim")
    public String submitUserClaimForm(@Valid @ModelAttribute("userClaim") UserClaim userClaim, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "userClaimForm";
        }
        userClaimService.processUserClaim(userClaim);
        model.addAttribute("userClaim", userClaim);
        return "result";
    }
}


