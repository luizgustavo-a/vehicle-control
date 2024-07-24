package br.com.parkment.vehicle_control.entities.vehicle.model;

public class Vehicle {
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private VehicleType type;

    public Vehicle() {}

    public Vehicle(String brand, String model, String color, String licensePlate, VehicleType type) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
