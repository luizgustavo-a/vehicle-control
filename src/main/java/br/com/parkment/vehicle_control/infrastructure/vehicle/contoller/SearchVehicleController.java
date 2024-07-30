package br.com.parkment.vehicle_control.infrastructure.vehicle.contoller;

import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehiclePublicDto;
import br.com.parkment.vehicle_control.usecases.vehicle.SearchVehicleByIdUseCase;
import br.com.parkment.vehicle_control.usecases.vehicle.SearchVehicleByLicencePlateUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SearchVehicleController {
    private final SearchVehicleByIdUseCase searchVehicleByIdUseCase;
    private final SearchVehicleByLicencePlateUseCase searchVehicleByLicencePlateUseCase;

    @GetMapping("vehicle/{identifier}")
    public ResponseEntity<VehiclePublicDto> searchVehicle(@PathVariable String identifier) throws VehicleNotFoundException {
        try {
            Long id = Long.parseLong(identifier);
            return ResponseEntity.ok(new VehiclePublicDto(searchVehicleByIdUseCase.execute(id)));
        } catch (NumberFormatException e) {
            //Verify if the input is an id and if not it means it is a license plate
        }
        return ResponseEntity.ok(new VehiclePublicDto(searchVehicleByLicencePlateUseCase.execute(identifier)));
    }

}
