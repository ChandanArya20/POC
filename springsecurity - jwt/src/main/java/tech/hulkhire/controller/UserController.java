package tech.hulkhire.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import tech.hulkhire.model.User;
import tech.hulkhire.pojo.UserLoginRequest;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;
import tech.hulkhire.pojo.UserUpdateRequest;
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
        return userService.saveUser(userReq);
    }
    
    @PostMapping("signin")
    public String signInUser(@RequestBody UserLoginRequest user){
        return userService.loginUser(user);
    }

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<UserResponse> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @PutMapping
    public UserResponse updateUser(@RequestBody UserUpdateRequest userReq){
        return userService.updateUser(userReq);
    }
}
