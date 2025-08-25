package com.example.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;
import com.example.services.IVehicleService;

@Service
public class VehicleServiceImpl implements IVehicleService {

    private final IVehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(IVehicleRepository vRepository) {
        this.vehicleRepository = vRepository;
    }

    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle findByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }

    @Override
    public void addToDriver(Driver driver, Vehicle vehicle) {
        vehicleRepository.addToDriver(driver, vehicle);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public void deleteByPlate(String plate) {

        if (plate == null || plate.isBlank()) {
            throw  new IllegalArgumentException("Plate can not be empty");
        }
        vehicleRepository.deleteByPlate(plate);

    }


	
}
