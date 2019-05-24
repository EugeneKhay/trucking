package com.eugene.trucking.controller;

import com.eugene.trucking.domain.Driver;
import com.eugene.trucking.repo.DriverRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("driver")
public class DriverController {

    @Autowired
    private DriverRepo driverRepo;

    @GetMapping
    public List<Driver> getAllDrivers() {
        return driverRepo.findAll();
    }

    @PostMapping()
    public Driver addDriver(@RequestBody Driver driver) {
        driverRepo.save(driver);
        return driver;
    }

    @PutMapping("{id}")
    public Driver updateDriver(@PathVariable Integer id,
                               @RequestBody Driver driver) {
        Optional<Driver> byId = driverRepo.findById(id);
        Driver driverFromDB = byId.get();
        driverFromDB.setName(driver.getName());
        driverFromDB.setSurname(driver.getSurname());
        driverFromDB.setPrivateNumber(driver.getPrivateNumber());
        driverRepo.save(driverFromDB);
        return driverFromDB;
    }

    @DeleteMapping("{id}")
    public void deleteDriver(@PathVariable Integer id) {
        final Optional<Driver> byId = driverRepo.findById(id);
        driverRepo.delete(byId.get());
    }
}
