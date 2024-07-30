package br.com.parkment.vehicle_control.usecases.vehicle.dto;

public interface IVehiclePublicDto {
    String id();
    String brand();
    String model();
    String color();
    String licensePlate();
    String type();
    String currentBranchId();
}
