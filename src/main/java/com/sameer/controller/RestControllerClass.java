package com.sameer.controller;

import com.sameer.model.UserInfo;
import com.sameer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//In Spring, a controller class, which is capable of serving REST API requests, is called rest controller.
// It should be annotated with @RestController annotation.
//The resource uris are specified in @RequestMapping annotations.
// It can be applied at class level and method level both.
// Complete URI for an API is resolved after adding class level path and method level path.


@RestController
public class RestControllerClass {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    private List getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    private UserInfo getUser(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/user/{id}")
    private void deleteUser(@PathVariable("id") int id) {
        userService.delete(id);
    }

    @PostMapping("/user")
    private int saveUser(@RequestBody UserInfo userInfo) {
        userService.saveOrUpdate(userInfo);
        return userInfo.getId();
    }
}
