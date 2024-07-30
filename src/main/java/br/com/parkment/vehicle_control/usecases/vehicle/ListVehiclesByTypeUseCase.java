package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListVehiclesByTypeUseCase {
    private final VehicleGateway vehicleGateway;

    public List<Vehicle> execute(String type) {
        return vehicleGateway.listVehiclesByType(VehicleType.fromString(type));
    }
}
