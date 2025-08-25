package com.example.services;

import java.util.List;

import com.example.model.Driver;
import com.example.model.Vehicle;

public interface IVehicleService {
    List<Vehicle> findAll();
    Vehicle findByPlate(String plate);
    void addToDriver(Driver driver, Vehicle vehicle);
    void addVehicle(Vehicle vehicle);
    void deleteByPlate(String plate);
}

