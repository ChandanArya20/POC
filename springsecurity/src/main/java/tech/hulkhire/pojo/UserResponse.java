package tech.hulkhire.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class UserResponse {
    Long id;
    String name;
    String email;
    private String[] roles;
}
