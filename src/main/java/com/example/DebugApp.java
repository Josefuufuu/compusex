package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.model.Driver;
import com.example.model.Vehicle;
import com.example.services.IDriverService;
import com.example.services.IVehicleService;

public class DebugApp {

    public static void main(String[] args) {
        // Context based on explicit @Bean definitions in AppConfig
        try (var ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

            // 1) Obtener beans (services)
            IDriverService driverService = ctx.getBean(IDriverService.class);
            IVehicleService vehicleService = ctx.getBean(IVehicleService.class);

            // 2) Crear un conductor
            Driver driver = new Driver(1, "Ana", "Operaria", "CC", "1001");
            driverService.addDriver(driver);
            // 3) Crear un vehículo y asignarlo al conductor
            Vehicle v1 = new Vehicle("Toyota", 1600, "Gasolina", 0,
                                     "MTR001", "AAA111", "2020");
            vehicleService.addToDriver(driver, v1);

            // 4) Mostrar resultados
            System.out.println("Conductores:");
            driverService.findAll().forEach(System.out::println);

            System.out.println("Vehículos:");
            vehicleService.findAll().forEach(System.out::println);
        }
    }
}

