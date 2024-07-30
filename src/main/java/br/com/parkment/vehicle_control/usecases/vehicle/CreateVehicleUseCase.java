package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;
import br.com.parkment.vehicle_control.usecases.vehicle.dto.IVehicleRegistrationData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateVehicleUseCase {
    private final VehicleGateway vehicleGateway;

    public Vehicle execute(IVehicleRegistrationData data) {
        Vehicle vehicle = new Vehicle(data.brand(), data.model(), data.color(), data.licensePlate(),
                VehicleType.fromString(data.type()));

        return vehicleGateway.createVehicle(vehicle);
    }
}
