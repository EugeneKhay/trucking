package com.eugene.trucking.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "COUNTRY_MAP")
public class CountryMap {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @OneToMany
    private Set<City> cities;

    //private List<Double> distancies;

}
