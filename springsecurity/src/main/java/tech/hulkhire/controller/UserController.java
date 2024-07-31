package tech.hulkhire.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.hulkhire.model.User;
import tech.hulkhire.pojo.UserLoginRequest;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;
import tech.hulkhire.service.UserService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("signup")
    public UserResponse saveUser(@RequestBody UserRequest userReq){
        User savedUser = userService.saveUser(userReq);
        return userService.getUserResponse(savedUser);
    }
    
    @PostMapping("signin")
    public String signInUser(UserLoginRequest user){
       return "Loggedin";
    }

    @GetMapping
    public List<UserResponse> fetchAllUsers(){
        List<User> users = userService.fetchAllUsers();
        return userService.getUserResponse(users);
    }
}
