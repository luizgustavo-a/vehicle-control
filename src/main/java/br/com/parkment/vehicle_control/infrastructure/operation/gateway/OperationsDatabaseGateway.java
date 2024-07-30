package br.com.parkment.vehicle_control.infrastructure.operation.gateway;

import br.com.parkment.vehicle_control.entities.operation.gateway.OperationGateway;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.OperationRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.schema.OperationSchema;
import lombok.AllArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
public class OperationsDatabaseGateway implements OperationGateway {
    private final OperationRepository operationRepository;

    @Override
    public Optional<Operation> searchLastOperationOfAVehicle(Long vehicleId) {
        return operationRepository.findAll()
                .stream()
                .filter(v -> v.getVehicle().getId().equals(vehicleId))
                .max(Comparator.comparing(OperationSchema::getTimestamp))
                .map(OperationSchema::toModel);
    }

    @Override
    public Optional<Operation> searchOperationById(String id) {
        return operationRepository.findById(UUID.fromString(id))
                .map(OperationSchema::toModel);
    }

    @Override
    public Operation enterVehicle(Operation operation) {
        return operationRepository.save(new OperationSchema(operation)).toModel();
    }

    @Override
    public Operation exitVehicle(Operation operation) {
        return operationRepository.save(new OperationSchema(operation)).toModel();
    }

    @Override
    public List<Operation> listAllOperations() {
        return operationRepository.findAll()
                .stream()
                .map(OperationSchema::toModel)
                .collect(Collectors.toList());
    }

}
