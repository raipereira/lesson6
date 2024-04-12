package miu.edu.cs489.lesson6.model;

import jakarta.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne(mappedBy = "user")
    private Role role;
}
