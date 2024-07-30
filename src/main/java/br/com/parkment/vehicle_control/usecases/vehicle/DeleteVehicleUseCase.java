package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteVehicleUseCase {
    private final VehicleGateway vehicleGateway;

    public Vehicle execute(Long id) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleGateway.searchVehicleById(id)
                .orElseThrow(VehicleNotFoundException::new);

        vehicleGateway.deleteVehicle(id);

        return vehicle;
    }
}
