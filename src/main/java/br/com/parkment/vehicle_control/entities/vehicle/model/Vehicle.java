package br.com.parkment.vehicle_control.entities.vehicle.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Vehicle {
    private Long id;
    private String brand;
    private String model;
    private String color;
    private String licensePlate;
    private VehicleType type;
    private Long currentBranch;
    private LocalDateTime entranceTime;
    private LocalDateTime exitTime;

    public Vehicle() {}

    public Vehicle(Long id, String brand, String model, String color, String licensePlate, VehicleType type, Long currentBranch, LocalDateTime entranceTime, LocalDateTime exitTime) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.type = type;
        this.currentBranch = currentBranch;
        this.entranceTime = entranceTime;
        this.exitTime = exitTime;
    }

    public Vehicle(String brand, String model, String color, String licensePlate, VehicleType type) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.licensePlate = licensePlate;
        this.type = type;
    }

}
