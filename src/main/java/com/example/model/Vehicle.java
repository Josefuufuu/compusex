package com.example.model;

public class Vehicle {
    int id;
    String plate;
    int cylinder;
    String fuel_type;
    String motor_number;
    String brand;
    String series;

    public Vehicle(String brand, int cylinder, String fuel_type, int id, String motor_number, String plate, String series) {
        this.brand = brand;
        this.cylinder = cylinder;
        this.fuel_type = fuel_type;
        this.id = id;
        this.motor_number = motor_number;
        this.plate = plate;
        this.series = series;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    public void setPlate(String plate) {
        this.plate = plate;
    }
    public void setCylinder(int cylinder) {
        this.cylinder = cylinder;
    }
    public void setFuel_type(String fuel_type) {
        this.fuel_type = fuel_type;
    }
    public void setMotor_number(String motor_number) {
        this.motor_number = motor_number;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public int getId() {
        return id;
    }
    public String getPlate() {
        return plate;
    }
    public int getCylinder() {
        return cylinder;
    }
    public String getFuel_type() {
        return fuel_type;
    }
    public String getMotor_number() {
        return motor_number;
    }
    public String getBrand() {
        return brand;
    }
    public String getSeries() {
        return series;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Driver{");
        sb.append("id=").append(id);
        sb.append(", plate=").append(plate);
        sb.append(", cylinder=").append(cylinder);
        sb.append(", fuel_type=").append(fuel_type);
        sb.append(", motor_number=").append(motor_number);
        sb.append(", brand=").append(brand);
        sb.append(", series=").append(series);
        sb.append('}');
        return sb.toString();
    }
    
    
}
