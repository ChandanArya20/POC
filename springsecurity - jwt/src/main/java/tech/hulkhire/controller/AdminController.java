package tech.hulkhire.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.hulkhire.pojo.UserLoginRequest;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;
import tech.hulkhire.pojo.UserUpdateRequest;
import tech.hulkhire.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("all-users")
    public List<UserResponse> fetchAllUsers(){
        return userService.fetchAllUsers();
    }

    @PostMapping
    public UserResponse createNewAdmin(@RequestBody UserLoginRequest userReq){
        return userService.makeUserAdmin(userReq);
    }

}
