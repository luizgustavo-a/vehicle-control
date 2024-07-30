package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListAllVehiclesUseCase {
    private final VehicleGateway vehicleGateway;

    public List<Vehicle> execute() {
        return vehicleGateway.listAllVehicles();
    }
}
