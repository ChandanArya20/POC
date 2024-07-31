package tech.hulkhire.repository;

import org.springframework.data.repository.CrudRepository;
import tech.hulkhire.model.User;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
