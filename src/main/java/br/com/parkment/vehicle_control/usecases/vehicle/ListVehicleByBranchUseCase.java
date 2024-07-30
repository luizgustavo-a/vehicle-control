package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListVehicleByBranchUseCase {
    private final VehicleGateway vehicleGateway;

    public List<Vehicle> execute(Long branchId) {
        return vehicleGateway.listVehiclesByBranch(branchId);
    }
}