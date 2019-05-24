package com.eugene.trucking.repo;

import com.eugene.trucking.domain.Truck;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TruckRepo extends JpaRepository<Truck, Long> {

    Optional<Truck> findById(Long id);
}
