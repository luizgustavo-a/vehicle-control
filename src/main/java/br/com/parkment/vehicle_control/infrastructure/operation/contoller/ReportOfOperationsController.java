package br.com.parkment.vehicle_control.infrastructure.operation.contoller;

import br.com.parkment.vehicle_control.infrastructure.operation.dto.OperationDto;
import br.com.parkment.vehicle_control.usecases.operation.ListAllOperationsUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

@AllArgsConstructor
@RestController
public class ReportOfOperationsController {
    private final ListAllOperationsUseCase listAllOperationsUseCase;

    @GetMapping(value = "/operation/report")
    public ResponseEntity<List<OperationDto>> listOperations(@RequestParam(required = false) Long branchId,
                                                             @RequestParam(required = false) Long vehicleId,
                                                             @RequestParam(required = false) String initialDate,
                                                             @RequestParam(required = false) String endDate ) {
        var listOperations = listAllOperationsUseCase.execute();

        if(branchId != null) {
            listOperations = listOperations.stream()
                    .filter(o -> o.getBranchId().getId().equals(branchId))
                    .toList();
        }
        if(vehicleId != null) {
            listOperations = listOperations.stream()
                    .filter(o -> o.getVehicleId().getId().equals(vehicleId))
                    .toList();
        }

        if((initialDate != null && !initialDate.isBlank()) || (endDate != null && !endDate.isBlank())) {
            LocalDate initialDateTime;
            LocalDate endDateTime;

            if (initialDate != null && !initialDate.isBlank()) {
                initialDateTime = LocalDate.parse(initialDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            } else {
                initialDateTime = LocalDate.MIN;
            }

            if (endDate != null && !endDate.isBlank()) {
                endDateTime = LocalDate.parse(endDate, DateTimeFormatter.ofPattern("dd/MM/yyyy")).plusDays(1);
            } else {
                endDateTime = LocalDate.now(ZoneId.systemDefault()).plusDays(1);
            }

            Instant firstInstant = initialDateTime.atStartOfDay(ZoneId.systemDefault()).toInstant();
            Instant lastInstant = endDateTime.atStartOfDay(ZoneId.systemDefault()).toInstant();

            if(firstInstant.isAfter(lastInstant)) {
                throw new IllegalArgumentException("Initial date cannot be prior to end date");
            }

            listOperations = listOperations.stream()
                    .filter(o -> o.getTimestamp().isAfter(firstInstant) && o.getTimestamp().isBefore(lastInstant))
                    .toList();
        }

        var filteredList = listOperations.stream()
                .map(OperationDto::new)
                .toList();

        return ResponseEntity.ok(filteredList);
    }
}
