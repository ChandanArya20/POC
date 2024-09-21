package tech.hulkhire.model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.ToString;

import java.util.List;

@Entity
@Builder
@ToString
public class Addresss {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String country;
    private String city;
    private String zipcode;
    private String phoneNum;

    @ManyToMany
    private List<User> users;

}
