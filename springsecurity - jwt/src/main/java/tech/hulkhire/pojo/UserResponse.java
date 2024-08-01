package tech.hulkhire.pojo;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
//@Builder
public class UserResponse {
    Long id;
    String name;
    String email;
    private String[] roles;
}
