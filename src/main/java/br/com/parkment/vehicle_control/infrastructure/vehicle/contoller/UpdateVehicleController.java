package br.com.parkment.vehicle_control.infrastructure.vehicle.contoller;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehiclePublicDto;
import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehicleUpdateDto;
import br.com.parkment.vehicle_control.usecases.vehicle.UpdateVehicleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UpdateVehicleController {
    private final UpdateVehicleUseCase updateVehicleUseCase;

    @PutMapping("/vehicle")
    @Transactional
    public ResponseEntity<VehiclePublicDto> updateVehicle(@RequestBody VehicleUpdateDto data) throws VehicleNotFoundException {
        var vehicle = new VehiclePublicDto(updateVehicleUseCase.execute(data));
        return ResponseEntity.ok(vehicle);
    }
}
