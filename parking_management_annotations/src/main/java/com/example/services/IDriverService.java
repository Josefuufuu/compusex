package com.example.services;

import java.util.List;

import com.example.model.Driver;

public interface  IDriverService {
    List<Driver> findAll();
    void addDriver(Driver driver);
    Driver getDriver(String ident_number);
    Driver save(Driver driver);
}
