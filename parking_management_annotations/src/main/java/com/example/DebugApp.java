package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.Config.AppConfig;
import com.example.services.IVehicleService;

public class DebugApp {
    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class)) {

            IVehicleService vehicleService = ctx.getBean(IVehicleService.class);

            System.out.println("Vehículos existentes:");
            vehicleService.findAll().forEach(System.out::println);

            // probar buscar por placa
            System.out.println(vehicleService.findByPlate("ABC123"));
        }
    }
}
