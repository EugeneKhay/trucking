package com.eugene.trucking.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "POINTS")
public class RoutePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @ManyToOne
    private City city;

    @ManyToOne
    private Cargo cargo;

    @Enumerated(EnumType.STRING)
    private PointType type;
}
