package br.com.parkment.vehicle_control.infrastructure.vehicle.dto;

import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.usecases.vehicle.dto.IVehiclePublicDto;

public record VehiclePublicDto(
        String id,
        String brand,
        String model,
        String color,
        String licensePlate,
        String type,
        String currentBranchId
) implements IVehiclePublicDto {
    public VehiclePublicDto(Vehicle vehicle) {
        this(String.valueOf(vehicle.getId()),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getColor(),
                vehicle.getLicensePlate(),
                String.valueOf(vehicle.getType()),
                String.valueOf(vehicle.getCurrentBranchId()));
    }
}
