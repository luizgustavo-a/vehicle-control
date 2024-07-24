package br.com.parkment.vehicle_control.entities.vehicle.model;

import java.util.Arrays;
import java.util.List;

public enum VehicleType {

    CAR (Arrays.asList("car", "carro")),
    MOTORCYCLE (Arrays.asList("motorcycle", "moto"));

    private final List<String> vehicles;

    VehicleType(List<String> vehicles) {
        this.vehicles = vehicles;
    }

    public static VehicleType fromString(String vehicle) {
        for (VehicleType type : VehicleType.values()) {
            if (type.getVehicles().stream().anyMatch(v -> v.equalsIgnoreCase(vehicle))) {
                return type;
            };
        }
        throw new IllegalArgumentException("Invalid vehicle type.");
    }

    public List<String> getVehicles() {
        return vehicles;
    }
}
