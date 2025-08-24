package com.example.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Driver;
import com.example.repository.impl.DriverRepositoryImpl;
import com.example.services.IDriverService;

@Service
public class DriverServiceImpl implements IDriverService{

    private DriverRepositoryImpl driverRepository;

    public DriverServiceImpl(DriverRepositoryImpl driverRepository){
        this.driverRepository = driverRepository;
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

    @Override
    public Driver save(Driver driver) {
        
       return  driverRepository.save(driver);
    }
    
}
