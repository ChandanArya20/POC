package tech.hulkhire.model;


import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class User {
    @Id
    private Long id;
    private String name;
    private String email;

}
