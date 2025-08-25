package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.repository.IVehicleRepository;

public class VehicleRepositoryImpl implements IVehicleRepository{

    private final List<Vehicle> vehicles = new  ArrayList<>();

    @Override
    public List<Vehicle> findAll() {
        return  vehicles;
    }

    @Override
    public Vehicle findByPlate(String plate) {
        return vehicles.stream().filter(v -> v.getPlate().equalsIgnoreCase(plate)).findFirst().orElse(null);
    }

    @Override
    public void addToDriver(Driver driver, Vehicle vehicle) {
        driver.addToDriver(vehicle);
        vehicles.add(vehicle);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    @Override
    public void deleteByPlate(String plate) {
        vehicles.removeIf(v -> v.getPlate().equalsIgnoreCase(plate));
    }
    
}
