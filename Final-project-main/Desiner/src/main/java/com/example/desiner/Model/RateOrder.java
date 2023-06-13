package com.example.desiner.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RateOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer customerId;


    private Integer OrderId;

    @Min(value = 1)
    @Max(value = 5)
    @Column(columnDefinition = "int not null ")
    private Integer rating;


    @OneToOne
    @JsonIgnore
    @MapsId
    private Order order;
}
