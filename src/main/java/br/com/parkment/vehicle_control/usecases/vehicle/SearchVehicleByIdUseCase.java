package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchVehicleByIdUseCase {
    private final VehicleGateway vehicleGateway;

    public Vehicle execute(Long id) throws VehicleNotFoundException {
        return vehicleGateway.searchVehicleById(id)
                .orElseThrow(VehicleNotFoundException::new);
    }
}
