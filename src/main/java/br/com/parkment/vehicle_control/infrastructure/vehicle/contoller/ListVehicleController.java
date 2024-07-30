package br.com.parkment.vehicle_control.infrastructure.vehicle.contoller;

import br.com.parkment.vehicle_control.infrastructure.vehicle.dto.VehiclePublicDto;
import br.com.parkment.vehicle_control.usecases.vehicle.ListAllVehiclesUseCase;
import br.com.parkment.vehicle_control.usecases.vehicle.ListVehicleByBranchUseCase;
import br.com.parkment.vehicle_control.usecases.vehicle.ListVehiclesByTypeUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ListVehicleController {
    private final ListAllVehiclesUseCase listAllVehiclesUseCase;
    private final ListVehiclesByTypeUseCase listVehiclesByTypeUseCase;
    private final ListVehicleByBranchUseCase listVehicleByBranchUseCase;

    @GetMapping("/vehicle")
    public ResponseEntity<List<VehiclePublicDto>> listVehicles(@RequestParam(required = false) String type) {
        List<VehiclePublicDto> listVehicles;

        if (type == null || type.isBlank()) {
            listVehicles = listAllVehiclesUseCase.execute()
                    .stream()
                    .map(VehiclePublicDto::new)
                    .toList();
        } else {
            listVehicles = listVehiclesByTypeUseCase.execute(type)
                    .stream()
                    .map(VehiclePublicDto::new)
                    .toList();
        }

        return ResponseEntity.ok(listVehicles);
    }

    @GetMapping("/branch/{branchId}/vehicles")
    public ResponseEntity<List<VehiclePublicDto>> listVehicles(@PathVariable Long branchId) {
        var listVehicles = listVehicleByBranchUseCase.execute(branchId)
                .stream()
                .map(VehiclePublicDto::new)
                .toList();

        return ResponseEntity.ok(listVehicles);
    }
}
