package br.com.parkment.vehicle_control.infrastructure.vehicle.dto;

import br.com.parkment.vehicle_control.usecases.vehicle.dto.IVehicleUpdateData;

public record VehicleUpdateDto (
        String id,
        String brand,
        String model,
        String color,
        String licensePlate,
        String type
) implements IVehicleUpdateData {
}
