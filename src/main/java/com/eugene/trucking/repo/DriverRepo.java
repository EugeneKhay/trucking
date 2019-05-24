package com.eugene.trucking.repo;

import com.eugene.trucking.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Integer> {

    Optional<Driver> findById(Integer id);
}
