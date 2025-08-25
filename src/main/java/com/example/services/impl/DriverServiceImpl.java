package com.example.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Driver;
import com.example.repository.impl.DriverRepositoryImpl;
import com.example.repository.impl.VehicleRepositoryImpl;
import com.example.services.IDriverService;

@Service 
public class DriverServiceImpl implements IDriverService{

    private final DriverRepositoryImpl driverRepository;
    private final VehicleRepositoryImpl vehicleRepository;

    public DriverServiceImpl(DriverRepositoryImpl driverRepository, VehicleRepositoryImpl vehicleRepository){
        this.driverRepository = driverRepository;
        this.vehicleRepository = vehicleRepository;


    }
    

    @Override
    public List<Driver> findAll(){
        return driverRepository.findAll();
    }

    @Override
    public void addDriver(Driver driver) {
       driverRepository.addDriver(driver);
    }

    @Override
    public Driver getDriver(String ident_number) {
        return driverRepository.getDriver(ident_number);
    }


    
}
