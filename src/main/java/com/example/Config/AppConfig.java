package com.example.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.repository.IDriverRepository;
import com.example.repository.IVehicleRepository;
import com.example.repository.impl.DriverRepositoryImpl;
import com.example.repository.impl.VehicleRepositoryImpl;
import com.example.services.IDriverService;
import com.example.services.IVehicleService;
import com.example.services.impl.DriverServiceImpl;
import com.example.services.impl.VehicleServiceImpl;

@Configuration
public class AppConfig {

    @Bean
    public IDriverRepository driverRepository() {
        return new DriverRepositoryImpl();
    }

    @Bean
    public IVehicleRepository vehicleRepository() {
        return new VehicleRepositoryImpl();
    }

    @Bean
    public IDriverService driverService(IDriverRepository driverRepository,
            IVehicleRepository vehicleRepository) {
        return new DriverServiceImpl(driverRepository, vehicleRepository);
    }

    @Bean
    public IVehicleService vehicleService(IVehicleRepository vehicleRepository) {
        return new VehicleServiceImpl(vehicleRepository);
    }

    @Bean
    public DataSeeder dataSeeder(IDriverService driverService, IVehicleService vehicleService) {
        return new DataSeeder(driverService, vehicleService);
    }
}

