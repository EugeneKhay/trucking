package com.eugene.trucking.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "DRIVERS")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer Id;

    private String name;

    private String surname;

    private int privateNumber;

    private int hoursThisMonth;

    @Enumerated(EnumType.STRING)
    private DriverStatus status;

    @OneToOne
    private City currentCity;

    @OneToOne
    private Truck currentTruck;

    public Driver(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

}
