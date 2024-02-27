package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User addUser(@RequestBody ObjectNode objectNode){
        System.out.println(objectNode);
        User u = new User();
        u.setUsername(objectNode.get("username").asText());
        u.setPassword(objectNode.get("password").asText());
        u.setName(objectNode.get("name").asText());
        u.setRole(objectNode.get("role").asText());
        long deptid = Long.parseLong(objectNode.get("deptid").asText());
        return userService.addUser(u, deptid);
    }
}
