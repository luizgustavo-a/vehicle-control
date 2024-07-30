package br.com.parkment.vehicle_control.infrastructure.vehicle.contoller;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehiclePublicDto;
import br.com.parkment.vehicle_control.usecases.vehicle.DeleteVehicleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DeleteVehicleController {
    private final DeleteVehicleUseCase deleteVehicleUseCase;

    @DeleteMapping("/vehicle/{id}")
    @Transactional
    public ResponseEntity<VehiclePublicDto> deleteVehicle(@PathVariable Long id) throws VehicleNotFoundException {
        var vehicle = new VehiclePublicDto(deleteVehicleUseCase.execute(id));

        return ResponseEntity.ok(vehicle);
    }
}
