package tech.hulkhire.repository;

import org.springframework.data.repository.CrudRepository;
import tech.hulkhire.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
