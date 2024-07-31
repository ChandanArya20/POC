package tech.hulkhire.service;

import tech.hulkhire.model.User;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User saveUser(UserRequest user);

    User getUserByEmail(String email);

    List<User> fetchAllUsers();

    UserResponse getUserResponse(User user);

    List<UserResponse> getUserResponse(List<User> users);
}
