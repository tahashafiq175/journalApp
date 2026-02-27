package com.edigest.journalApp.controller;

import com.edigest.journalApp.entity.User;
import com.edigest.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/public")
public class PublicController {
    @Autowired
    private UserService userService;
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAll();
    }
    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
    @PostMapping("/create-user")
    public void createUser(@RequestBody User user){
        userService.saveNewUser(user);
    }
}
