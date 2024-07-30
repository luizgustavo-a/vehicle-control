package br.com.parkment.vehicle_control.infrastructure.operation.contoller;

import br.com.parkment.vehicle_control.entities.operation.exception.InvalidOperationException;
import br.com.parkment.vehicle_control.entities.operation.exception.OperationNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.operation.dto.OperationDto;
import br.com.parkment.vehicle_control.usecases.operation.ExitVehicleFromBranchUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
public class ExitVehicleController {
    private final ExitVehicleFromBranchUseCase exitVehicleFromBranchUseCase;

    @PostMapping("/operation/{branchId}/exit/{vehicleId}")
    @Transactional
    public ResponseEntity<OperationDto> vehicleOperation(@PathVariable Long branchId,
                                                         @PathVariable Long vehicleId,
                                                         UriComponentsBuilder builder)
            throws InvalidOperationException, OperationNotFoundException, VehicleNotFoundException {

        var operation = new OperationDto(exitVehicleFromBranchUseCase.execute(branchId, vehicleId));
        var uri = builder.path("/operation/{operationId}").buildAndExpand(operation.id()).toUri();

        return ResponseEntity.created(uri).body(operation);
    }
}
