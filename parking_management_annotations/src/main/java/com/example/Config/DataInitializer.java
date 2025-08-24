package com.example.Config;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.services.IDriverService;
import com.example.services.IVehicleService;

@Component
public class DataInitializer {

    private final IDriverService driverService;
    private final IVehicleService vehicleService;

    public DataInitializer(IDriverService driverService, IVehicleService vehicleService) {
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void init() {
        Driver d1 = new Driver(1, "Juan Perez", "Conductor", "CC", "123");
        Driver d2 = new Driver(2, "Maria Gomez", "Conductor", "CC", "456");
        Driver d3 = new Driver(3, "Carlos Ruiz", "Conductor", "CC", "789");

        driverService.addDriver(d1);
        driverService.addDriver(d2);
        driverService.addDriver(d3);

        vehicleService.addToDriver(d1, new Vehicle("Toyota", 1600, "Gasolina", 1, "MOTOR000001", "AAA111", "2020"));
        vehicleService.addToDriver(d1, new Vehicle("Mazda", 2000, "Gasolina", 2, "MOTOR000002", "BBB222", "2019"));
        vehicleService.addToDriver(d1, new Vehicle("Renault", 1800, "Diesel", 3, "MOTOR000003", "CCC333", "2018"));

        vehicleService.addToDriver(d2, new Vehicle("Chevrolet", 1500, "Gasolina", 4, "MOTOR000004", "DDD444", "2021"));
        vehicleService.addToDriver(d2, new Vehicle("Ford", 2200, "Gasolina", 5, "MOTOR000005", "EEE555", "2020"));
        vehicleService.addToDriver(d2, new Vehicle("Hyundai", 1600, "Gasolina", 6, "MOTOR000006", "FFF666", "2017"));

        vehicleService.addToDriver(d3, new Vehicle("Kia", 1400, "Gasolina", 7, "MOTOR000007", "GGG777", "2016"));
        vehicleService.addToDriver(d3, new Vehicle("Nissan", 1900, "Gasolina", 8, "MOTOR000008", "HHH888", "2015"));
        vehicleService.addToDriver(d3, new Vehicle("Volkswagen", 2000, "Diesel", 9, "MOTOR000009", "III999", "2014"));
    }
}
