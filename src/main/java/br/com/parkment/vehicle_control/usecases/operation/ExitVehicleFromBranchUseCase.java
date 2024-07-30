package br.com.parkment.vehicle_control.usecases.operation;

import br.com.parkment.vehicle_control.entities.operation.exception.InvalidOperationException;
import br.com.parkment.vehicle_control.entities.operation.exception.OperationNotFoundException;
import br.com.parkment.vehicle_control.entities.operation.gateway.OperationGateway;
import br.com.parkment.vehicle_control.entities.operation.model.Event;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;

import java.time.Instant;


@AllArgsConstructor
public class ExitVehicleFromBranchUseCase {
    private final OperationGateway operationGateway;
    private final VehicleGateway vehicleGateway;

    public Operation execute(Long branchId, Long vehicleId) throws InvalidOperationException,
            OperationNotFoundException, VehicleNotFoundException {
        Vehicle vehicle = vehicleGateway.searchVehicleById(vehicleId)
                .orElseThrow(VehicleNotFoundException::new);

        Operation operation = operationGateway.searchLastOperationOfAVehicle(vehicleId)
                .orElseThrow(OperationNotFoundException::new);
        boolean isVehicleParked = operation.getEvent() == Event.ENTRY;

        if (isVehicleParked && operation.getBranchId().getId().equals(branchId)) {
            operation.setEvent(Event.EXIT);
            operation.setTimestamp(Instant.now());

            vehicle.setCurrentBranchId(null);
            vehicleGateway.updateVehicle(vehicle);

            return operationGateway.exitVehicle(operation);
        }

        throw new InvalidOperationException();
    }

}
