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
public class DesignerBusiness {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition = "varchar(50) not null ")
    private String achievement;

    @Column(columnDefinition = "varchar(200) not null ")
    private String body;



    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonIgnore
    private Designer designer;



    @OneToOne(cascade = CascadeType.ALL,mappedBy = "designerBusiness")
    @PrimaryKeyJoinColumn
    private Image image;

}
