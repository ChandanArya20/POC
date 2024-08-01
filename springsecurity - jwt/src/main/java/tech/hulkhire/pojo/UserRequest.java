package tech.hulkhire.pojo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Set;

@Data
public class UserRequest {
    String name;
    String email;
    String password;
}
