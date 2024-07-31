package tech.hulkhire.pojo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    Long id;
    String name;
    String email;
    String password;
    boolean isActive;

    private Set<String> roles;
}
