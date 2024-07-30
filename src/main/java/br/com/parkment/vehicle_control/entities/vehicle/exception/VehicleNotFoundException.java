package br.com.parkment.vehicle_control.entities.vehicle.exception;

public class VehicleNotFoundException extends Exception {
    public VehicleNotFoundException() {
        super("Vehicle not found!");
    }
}
