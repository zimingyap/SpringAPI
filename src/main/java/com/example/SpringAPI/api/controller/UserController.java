package com.example.SpringAPI.api.controller;

import com.example.SpringAPI.api.model.User;
import com.example.SpringAPI.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.Option;
import java.util.Optional;
// Checking
@RestController
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/user")
    public User getUser(@RequestParam Integer id){
        Optional user = userService.getUser(id);
        if (user.isPresent()){
            return (User) user.get();
        }
        return null;
    }
}
