package br.com.parkment.vehicle_control.usecases.vehicle.dto;

public interface IVehicleUpdateData {
    String id();
    String brand();
    String model();
    String color();
    String licensePlate();
    String type();
}
