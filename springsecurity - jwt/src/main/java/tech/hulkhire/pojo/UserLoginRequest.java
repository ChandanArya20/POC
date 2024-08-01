package tech.hulkhire.pojo;

import lombok.Data;

@Data
public class UserLoginRequest {
    String email;
    String password;
}
