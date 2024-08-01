package tech.hulkhire.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class UserUpdateRequest {
    String name;
    String password;
    Boolean active;
}
