package com.example.myapp.controller;

import com.example.myapp.model.User;
import com.example.myapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.register(user);
        return "redirect:/login";
    }

    @GetMapping("/{username}")
    @ResponseBody
    public User getUserByUsername(@PathVariable String username) {
        return userService.findUserByUsername(username);
    }
}
