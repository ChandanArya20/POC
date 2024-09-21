//package tech.hulkhire.model;
//
//
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.ToString;
//
//import java.util.List;
//
//@Entity
//@Builder
//@ToString
//public class User2 {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//    private String name;
//    private String email;
//
//    @OneToMany(cascade = CascadeType.ALL)
//    private List<Addresss> address;
//
//}
