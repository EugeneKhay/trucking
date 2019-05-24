package com.eugene.trucking.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "TRUCKS")
public class Truck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String regNumber;

    private int driverChange;

    private double capacity;

    private boolean state;

    @OneToOne
    private City currentCity;
}
