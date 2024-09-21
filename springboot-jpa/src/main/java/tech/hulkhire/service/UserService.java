package tech.hulkhire.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.hulkhire.model.User;
import tech.hulkhire.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public List<User> saveAllUser(List<User> user){
        return (List<User>) userRepository.saveAll(user);
    }

}
