package br.com.parkment.vehicle_control.usecases.operation;

import br.com.parkment.vehicle_control.entities.operation.exception.OperationNotFoundException;
import br.com.parkment.vehicle_control.entities.operation.gateway.OperationGateway;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchLastOperationOfAVehicleUseCase {
    private final OperationGateway operationGateway;

    public Operation execute(Long vehicleId) throws OperationNotFoundException {
        return operationGateway.searchLastOperationOfAVehicle(vehicleId)
                .orElseThrow(OperationNotFoundException::new);
    }
}
