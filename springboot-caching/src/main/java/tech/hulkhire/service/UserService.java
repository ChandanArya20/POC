package tech.hulkhire.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import tech.hulkhire.model.User;
import tech.hulkhire.repository.UserRepository;

import java.util.Optional;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Cacheable(value = "users", key = "#id")
    public Optional<User> getUserById(Long id) {
        log.info("Fetching user with id {} from database", id);
//        simulateSlowService();
        return userRepository.findById(id);
    }

    public User saveUser(User user) {
        log.info("Saving user with name {}", user.getName());
        return userRepository.save(user);
    }

    @CachePut(value = "users", key = "#user.id")
    public User updateUser(User user) {
        log.info("Updating user with id {}", user.getId());
        return userRepository.save(user);
    }

    @CacheEvict(value = "users", key = "#id")
    public void deleteUser(Long id) {
        log.info("Deleting user with id {}", id);
        userRepository.deleteById(id);
    }

    @Caching(evict = {
            @CacheEvict(value = "users", key = "#id"),
            @CacheEvict(value = "users", allEntries = true)
    })
    public void deleteUserAndClearCache(Long id) {
        log.info("Deleting user with id {} and clearing all cache entries", id);
        userRepository.deleteById(id);
    }

    // Simulate a slow service to see caching in action
    private void simulateSlowService() {
        try {
            log.info("Simulating slow service...");
            Thread.sleep(3000L);
            log.info("Service simulation complete.");
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
