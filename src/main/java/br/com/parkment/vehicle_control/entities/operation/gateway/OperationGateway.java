package br.com.parkment.vehicle_control.entities.operation.gateway;

import br.com.parkment.vehicle_control.entities.operation.model.Operation;

import java.util.List;
import java.util.Optional;

public interface OperationGateway {
    Optional<Operation> searchLastOperationOfAVehicle(Long vehicleId);
    Optional<Operation> searchOperationById(String id);

    Operation enterVehicle(Operation operation);
    Operation exitVehicle(Operation operation);

    List<Operation> listAllOperations();
}
