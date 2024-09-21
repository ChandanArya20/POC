//package tech.hulkhire.model;
//
//
//import jakarta.persistence.*;
//import lombok.Builder;
//import lombok.ToString;
//
//@Entity
//@Builder
//@ToString
//public class Userr {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
//    private String id;
//    private String name;
//    private String email;
//
//    @OneToOne(cascade = CascadeType.ALL )
//    private Addresss address;
//
//}
