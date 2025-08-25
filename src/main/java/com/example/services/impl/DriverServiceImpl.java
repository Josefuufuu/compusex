package com.example.services.impl;

import java.util.List;

import com.example.model.Driver;
import com.example.repository.IDriverRepository;
import com.example.repository.IVehicleRepository;
import com.example.services.IDriverService;

public class DriverServiceImpl implements IDriverService {

    private final IDriverRepository driverRepository;
    private final IVehicleRepository vehicleRepository;

    public DriverServiceImpl(IDriverRepository driverRepository, IVehicleRepository vehicleRepository) {
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
