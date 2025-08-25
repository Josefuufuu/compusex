package com.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.services.IDriverService;
import com.example.services.IVehicleService;

public class DebugAppXml {

    public static void main(String[] args) {
        try (var ctx = new ClassPathXmlApplicationContext("applicationContext.xml")) {

            IDriverService driverService = ctx.getBean(IDriverService.class);
            IVehicleService vehicleService = ctx.getBean(IVehicleService.class);

            Driver driver = new Driver(1, "Ana", "Operaria", "CC", "1001");
            driverService.addDriver(driver);

            Vehicle v1 = new Vehicle("Toyota", 1600, "Gasolina", 0,
                                     "MTR001", "AAA111", "2020");
            vehicleService.addToDriver(driver, v1);

            System.out.println("Conductores:");
            driverService.findAll().forEach(System.out::println);

            System.out.println("Vehículos:");
            vehicleService.findAll().forEach(System.out::println);
        }
    }
}

