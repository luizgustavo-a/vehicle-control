package br.com.parkment.vehicle_control.infrastructure.operation.contoller;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.entities.operation.exception.InvalidOperationException;
import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.operation.dto.OperationDto;
import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehicleRegistrationDto;
import br.com.parkment.vehicle_control.usecases.operation.EnterVehicleToBranchUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
public class EnterVehicleController {
    private final EnterVehicleToBranchUseCase enterVehicleToBranchUseCase;

    @PostMapping("/operation/{branchId}/entry/{vehicleId}")
    @Transactional
    public ResponseEntity<OperationDto> vehicleOperation(@PathVariable Long branchId,
                                                         @PathVariable Long vehicleId,
                                                         UriComponentsBuilder builder)
            throws VehicleNotFoundException, BranchNotFoundException, InvalidOperationException {

        var operation = new OperationDto(enterVehicleToBranchUseCase.execute(branchId, vehicleId));
        var uri = builder.path("/operation/{operationId}").buildAndExpand(operation.id()).toUri();

        return ResponseEntity.created(uri).body(operation);
    }

    @PostMapping("/operation/{branchId}/entry")
    @Transactional
    public ResponseEntity<OperationDto> vehicleOperation(@PathVariable Long branchId,
                                                         @RequestBody VehicleRegistrationDto vehicleRegistrationDto,
                                                         UriComponentsBuilder builder)
            throws BranchNotFoundException, InvalidOperationException {

        var operation = new OperationDto(enterVehicleToBranchUseCase.execute(branchId, vehicleRegistrationDto));
        var uri = builder.path("/operation/{operationId}").buildAndExpand(operation.id()).toUri();

        return ResponseEntity.created(uri).body(operation);
    }
}
