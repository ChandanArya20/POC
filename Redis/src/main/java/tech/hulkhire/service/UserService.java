package tech.hulkhire.service;

import tech.hulkhire.model.User;

import java.util.Optional;

public interface UserService {

    Optional<User> getUserById(Long id);

    User saveUser(User user);

    User updateUser(User user);

    void deleteUser(Long id);

    void deleteUserAndClearCache(Long id);
}
