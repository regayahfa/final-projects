package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(20) not null ")
    private String name;


    @Email
    @Column(columnDefinition = "varchar(50) not null ")
    private String email;

    @Column(columnDefinition = "varchar(20) not null ")
    private String location;

    @OneToOne
    @MapsId
    @JsonIgnore
    private MyUser myUser;



    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Set<Order> orders;
}
