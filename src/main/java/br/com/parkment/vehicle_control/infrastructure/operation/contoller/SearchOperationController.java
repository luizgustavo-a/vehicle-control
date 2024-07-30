package br.com.parkment.vehicle_control.infrastructure.operation.contoller;

import br.com.parkment.vehicle_control.entities.operation.exception.OperationNotFoundException;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import br.com.parkment.vehicle_control.usecases.operation.SearchLastOperationOfAVehicleUseCase;
import br.com.parkment.vehicle_control.usecases.operation.SearchOperationByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SearchOperationController {
    private final SearchOperationByIdUseCase searchOperationByIdUseCase;
    private final SearchLastOperationOfAVehicleUseCase searchLastOperationOfAVehicleUseCase;

    @GetMapping("operation/{id}")
    public ResponseEntity<Operation> searchOperation(@PathVariable String id) throws OperationNotFoundException {
        return ResponseEntity.ok(searchOperationByIdUseCase.execute(id));
    }

    @GetMapping("operation/last/{vehicleId}")
    public ResponseEntity<Operation> searchLastOperation(@PathVariable Long vehicleId) throws OperationNotFoundException {
        return ResponseEntity.ok(searchLastOperationOfAVehicleUseCase.execute(vehicleId));
    }
}
