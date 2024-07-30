package br.com.parkment.vehicle_control.usecases.operation;

import br.com.parkment.vehicle_control.entities.operation.gateway.OperationGateway;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListAllOperationsUseCase {
    private final OperationGateway operationGateway;

    public List<Operation> execute() {
        return operationGateway.listAllOperations();
    }
}
