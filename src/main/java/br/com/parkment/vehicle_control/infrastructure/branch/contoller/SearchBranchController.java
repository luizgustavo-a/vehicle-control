package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchPublicDto;
import br.com.parkment.vehicle_control.usecases.branch.SearchBranchByIdUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class SearchBranchController {
    public SearchBranchByIdUseCase searchBranchByIdUseCase;

    @GetMapping("/branch/{id}")
    public ResponseEntity<BranchPublicDto> searchBranchById(@PathVariable Long id) throws BranchNotFoundException {
        var branch = new BranchPublicDto(searchBranchByIdUseCase.execute(id));

        return ResponseEntity.ok(branch);
    }
}
