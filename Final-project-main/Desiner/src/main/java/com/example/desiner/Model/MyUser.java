package com.example.desiner.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

//@Table(name = "user")
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) unique not null ")
    @NotEmpty
    private String username;


    @Pattern(regexp = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$")
    @Column(columnDefinition = "varchar(20) unique not null ")
    @NotEmpty
    private String password;

    @NotEmpty
    @Column(columnDefinition = "varchar(20) not null check( role='Customer' or role='Designer' )")
    private String role;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Customer customer;


    @OneToOne(cascade = CascadeType.ALL,mappedBy = "myUser")
    @PrimaryKeyJoinColumn
    private Designer designer;

}
