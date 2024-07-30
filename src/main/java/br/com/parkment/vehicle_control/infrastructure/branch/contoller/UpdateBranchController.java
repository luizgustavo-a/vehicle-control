package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchPublicDto;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchUpdateDto;
import br.com.parkment.vehicle_control.usecases.branch.UpdateBranchUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UpdateBranchController {
    private final UpdateBranchUseCase updateBranchUseCase;

    @PutMapping("/branch")
    @Transactional
    public ResponseEntity<BranchPublicDto> updateBranch(@RequestBody BranchUpdateDto data) throws BranchNotFoundException {
        var branch = new BranchPublicDto(updateBranchUseCase.execute(data));
        return ResponseEntity.ok(branch);
    }
}
