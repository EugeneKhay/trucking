package com.eugene.trucking.controller;

import com.eugene.trucking.domain.Truck;
import com.eugene.trucking.repo.TruckRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("truck")
public class TruckController {

    @Autowired
    private TruckRepo truckRepo;

    @GetMapping
    public List<Truck> getAllTrucks() {
        return truckRepo.findAll();
    }

    @PostMapping()
    public Truck addTruck(@RequestBody Truck truck) {
        truckRepo.save(truck);
        return truck;
    }

    @PutMapping("{id}")
    public Truck updateTruck(@PathVariable Long id,
                             @RequestBody Truck truck) {
        Optional<Truck> byId = truckRepo.findById(id);
        Truck truckFromDB = byId.get();
        truckFromDB.setRegNumber(truck.getRegNumber());
        truckFromDB.setCapacity(truck.getCapacity());
        truckFromDB.setDriverChange(truck.getDriverChange());
        truckFromDB.setState(truck.isState());
        truckRepo.save(truckFromDB);
        return truckFromDB;
    }

    @DeleteMapping("{id}")
    public void deleteTruck(@PathVariable Long id) {
        final Optional<Truck> byId = truckRepo.findById(id);
        truckRepo.delete(byId.get());
    }
}
