package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    int id;
    String name;
    String position;
    String id_type;
    String ident_number;

    List<Vehicle> vehicles = new ArrayList<>();

    public Driver(int id, String name, String position, String id_type, String ident_number) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.id_type = id_type;
        this.ident_number = ident_number;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getId_type() {
        return id_type;
    }

    public void setId_type(String id_type) {
        this.id_type = id_type;
    }

    public String getId_number() {
        return ident_number;
    }

    public void setId_number(String id_number) {
        this.ident_number = id_number;
    }

    public void addToDriver(Vehicle vehicle){
        vehicles.add(vehicle);
    }

    public List<Vehicle> getVehicles(){
        return vehicles;
    }

}


