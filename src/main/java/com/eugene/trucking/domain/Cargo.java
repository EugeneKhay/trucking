package com.eugene.trucking.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CARGO")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int cargoNumber;

    private String name;

    private double weight;

    @Enumerated(EnumType.STRING)
    private CargoStatus cargoStatus;
}
