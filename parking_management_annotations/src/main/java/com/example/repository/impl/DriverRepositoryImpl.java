package com.example.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.model.Driver;
import com.example.repository.IDriverRepository;

@Repository
public class DriverRepositoryImpl implements IDriverRepository{

    List<Driver> drivers = new ArrayList<>();

    @Override
    public List<Driver> findAll() {
        return drivers;
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.add(driver);

    }

    @Override
    public Driver getDriver(String ident_number) {

       return  drivers.stream().filter(d -> d.getId_number().equalsIgnoreCase(ident_number)).findFirst().orElse(null);
    }

    @Override
    public Driver save(Driver driver) {
        drivers.removeIf(d -> d.getId_number().equalsIgnoreCase(driver.getId_number()));
        drivers.add(driver);
        return driver;
    }


    
}
