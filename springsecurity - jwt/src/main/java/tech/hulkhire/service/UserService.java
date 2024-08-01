package tech.hulkhire.service;

import tech.hulkhire.model.User;
import tech.hulkhire.pojo.UserLoginRequest;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;
import tech.hulkhire.pojo.UserUpdateRequest;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserResponse saveUser(UserRequest userReq);

    UserResponse updateUser(UserUpdateRequest userReq);

    User getUserByEmail(String email);

    List<UserResponse> fetchAllUsers();

    UserResponse makeUserAdmin(UserLoginRequest userReq);

    String loginUser(UserLoginRequest user);
}
