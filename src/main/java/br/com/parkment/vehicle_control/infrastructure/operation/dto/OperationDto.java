package br.com.parkment.vehicle_control.infrastructure.operation.dto;

import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import br.com.parkment.vehicle_control.usecases.operation.dto.IOperationDto;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public record OperationDto(
        String id,
        String branchId,
        String vehicleId,
        String event,
        String timestamp
) implements IOperationDto {
    public OperationDto(Operation operation) {
        this(
                operation.getId(),
                String.valueOf(operation.getBranchId().getId()),
                String.valueOf(operation.getVehicleId().getId()),
                operation.getEvent().toString(),
                operation.getTimestamp().atZone(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"))
        );
    }
}
