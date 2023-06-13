package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Services {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "varchar(50)  not null ")
    private String name;


    @Column(columnDefinition = "varchar(20) not null check( category='Customer' or category='Designer' )")
    private String category;


    @Column(columnDefinition = "varchar(200)  not null ")
    private String description;


    @Column(columnDefinition = "int not null ")
    private Integer price;


    private Integer designerId;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private Designer designer;
}
