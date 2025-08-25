package com.example.Config;

import jakarta.annotation.PostConstruct;

import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.services.IDriverService;
import com.example.services.IVehicleService;

public class DataSeeder {

    private final IDriverService driverService;
    private final IVehicleService vehicleService;

    public DataSeeder(IDriverService driverService, IVehicleService vehicleService) {
        this.driverService = driverService;
        this.vehicleService = vehicleService;
    }

    @PostConstruct
    public void init() {

        // Instancias de conductor
        Driver d1 = new Driver(0, "Faiber", "Competitive Driver", "C.C", "1061198722");
        Driver d2 = new Driver(1, "Joseph", "Truck Driver", "PASSPORT", "7777777777");
        Driver d3 = new Driver(2, "Rubio", "F1 Driver", "CARNET_ICESI", "7878787878");

     // Guardar los conductores en el repositorio
        driverService.addDriver(d1);
        driverService.addDriver(d2);
        driverService.addDriver(d3);


        // Instancias de vehiculos
        vehicleService.addToDriver(d1, new Vehicle("Toyota", 1600, "Gasolina", 0, "MTR001","AAA111","2020"));
        vehicleService.addToDriver(d1, new Vehicle("Mazda", 2000, "Gasolina", 1, "MTR002","BBB222","2019"));
        vehicleService.addToDriver(d1, new Vehicle("Ferrari", 1400, "Gasolina", 2, "MTR003","CCC333","2018"));

        vehicleService.addToDriver(d2, new Vehicle("Lamborghini", 1500, "Gasolina", 3, "MTR004","DDD444","2017"));
        vehicleService.addToDriver(d2, new Vehicle("Terrenator", 1800, "Gasolina", 4, "MTR005","EEE555","2016"));
        vehicleService.addToDriver(d2, new Vehicle("El chevere", 1500, "Gasolina", 5, "MTR006","FFF666","2015"));

        vehicleService.addToDriver(d3, new Vehicle("Chebroleds", 2400, "Gasolina", 6, "MTR007","GGG777","2014"));
        vehicleService.addToDriver(d3, new Vehicle("Micky", 2600, "Gasolina", 7, "MTR008","HHH888","2013"));
        vehicleService.addToDriver(d3, new Vehicle("Coyote", 2800, "Gasolina", 8, "MTR009","III999","2012"));

    }






}

