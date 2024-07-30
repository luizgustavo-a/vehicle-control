package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchVehicleByLicencePlateUseCase {
    private final VehicleGateway vehicleGateway;

    public Vehicle execute(String licensePlate) throws VehicleNotFoundException {
        return vehicleGateway.searchVehicleByLicensePlate(licensePlate)
                .orElseThrow(VehicleNotFoundException::new);
    }
}
