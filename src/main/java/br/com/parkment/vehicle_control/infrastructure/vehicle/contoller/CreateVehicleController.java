package br.com.parkment.vehicle_control.infrastructure.vehicle.contoller;

import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehiclePublicDto;
import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehicleRegistrationDto;
import br.com.parkment.vehicle_control.usecases.vehicle.CreateVehicleUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
public class CreateVehicleController {
    private final CreateVehicleUseCase createVehicleUseCase;

    @PostMapping("/vehicle")
    @Transactional
    public ResponseEntity<VehiclePublicDto> createVehicle(@RequestBody VehicleRegistrationDto data,
                                                          UriComponentsBuilder builder) {
        var vehicle = new VehiclePublicDto(createVehicleUseCase.execute(data));
        var uri = builder.path("/vehicle/{id}").buildAndExpand(vehicle.id()).toUri();

        return ResponseEntity.created(uri).body(vehicle);
    }
}
