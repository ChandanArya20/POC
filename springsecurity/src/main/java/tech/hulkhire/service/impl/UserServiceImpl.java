package tech.hulkhire.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hulkhire.exception.UserNotFoundException;
import tech.hulkhire.model.User;
import tech.hulkhire.pojo.UserRequest;
import tech.hulkhire.pojo.UserResponse;
import tech.hulkhire.repository.UserRepository;
import tech.hulkhire.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Override
    public User saveUser(UserRequest userReq) {
        User user = new User();
        BeanUtils.copyProperties(userReq, user);
        return userRepo.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(
                () -> new UserNotFoundException("User not found with email : " + email));
    }

    @Override
    public List<User> fetchAllUsers() {
        return (List<User>) userRepo.findAll();
    }

    @Override
    public UserResponse getUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        String[] roles = user.getRoles().toArray(new String[0]);
        BeanUtils.copyProperties(user, userResponse);
        userResponse.setRoles(roles);

        return userResponse;
    }

    @Override
    public List<UserResponse> getUserResponse(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user: users){
            userResponses.add(getUserResponse(user));
        }

        return userResponses;
    }
}
