package br.com.parkment.vehicle_control.usecases.vehicle;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;
import br.com.parkment.vehicle_control.usecases.vehicle.dto.IVehicleUpdateData;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateVehicleUseCase {
    private final VehicleGateway vehicleGateway;

    public Vehicle execute(IVehicleUpdateData data) throws VehicleNotFoundException {
        Vehicle vehicle = vehicleGateway.searchVehicleById(Long.parseLong(data.id()))
                .orElseThrow(VehicleNotFoundException::new);

        if (data.brand() != null && !data.brand().isBlank()) {
            vehicle.setBrand(data.brand());
        }
        if (data.model() != null && !data.model().isBlank()) {
            vehicle.setModel(data.model());
        }
        if (data.color() != null && !data.color().isBlank()) {
            vehicle.setColor(data.color());
        }
        if (data.licensePlate() != null && !data.licensePlate().isBlank()) {
            vehicle.setLicensePlate(data.licensePlate());
        }
        if (data.type() != null && !data.type().isBlank()) {
            vehicle.setType(VehicleType.fromString(data.type()));
        }

        return vehicleGateway.updateVehicle(vehicle);
    }
}
