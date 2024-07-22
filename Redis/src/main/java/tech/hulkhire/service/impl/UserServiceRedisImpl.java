package tech.hulkhire.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.hulkhire.model.User;
import tech.hulkhire.repository.UserRepository;
import tech.hulkhire.service.RedisService;
import tech.hulkhire.service.UserService;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
@Slf4j
@Primary
public class UserServiceRedisImpl implements UserService {

    private static final String USER_CACHE_KEY_PREFIX = "user::";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RedisService redisService;

    @Override
    public Optional<User> getUserById(Long id) {
        String cacheKey = USER_CACHE_KEY_PREFIX + id;
        User cachedUser = (User) redisService.find(cacheKey);

        if (cachedUser != null) {
            log.info("Fetching user with id {} from cache", id);
            return Optional.of(cachedUser);
        } else {
            log.info("Fetching user with id {} from database", id);
            Optional<User> user = userRepository.findById(id);
            user.ifPresent(u -> redisService.save(cacheKey, user.get()));
            return user;
        }
    }

    @Override
    public User saveUser(User user) {
        log.info("Saving user with name {}", user.getName());
        User savedUser = userRepository.save(user);
        String cacheKey = USER_CACHE_KEY_PREFIX + savedUser.getId();
        redisService.save(cacheKey, savedUser); // Cache the saved user
        return savedUser;
    }

    @Override
    public User updateUser(User user) {
        log.info("Updating user with id {}", user.getId());
        User updatedUser = userRepository.save(user);
        String cacheKey = USER_CACHE_KEY_PREFIX + updatedUser.getId();
        redisService.save(cacheKey, updatedUser); // Update cache
        return updatedUser;
    }

    @Override
    public void deleteUser(Long id) {
        log.info("Deleting user with id {}", id);
        userRepository.deleteById(id);
        String cacheKey = USER_CACHE_KEY_PREFIX + id;
        redisService.delete(cacheKey); // Remove from cache
    }

    @Override
    public void deleteUserAndClearCache(Long id) {
        log.info("Deleting user with id {} and clearing all cache entries", id);
        userRepository.deleteById(id);
        String cacheKey = USER_CACHE_KEY_PREFIX + id;
        redisService.delete(cacheKey); // Remove from cache
    }
}
