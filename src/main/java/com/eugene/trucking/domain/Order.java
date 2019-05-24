package com.eugene.trucking.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private int orderNumber;

    private boolean isDone;

    @OneToMany
    private List<RoutePoint> routePoints;

    @OneToOne
    private Truck truckForOrder;

    @OneToMany
    private List<Driver> orderDrivers;


}
