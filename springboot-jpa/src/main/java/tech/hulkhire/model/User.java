package tech.hulkhire.model;


import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Entity
@Builder
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String email;

    @ManyToMany
    private List<Addresss> address;

}
