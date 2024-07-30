package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchPublicDto;
import br.com.parkment.vehicle_control.usecases.branch.DeleteBranchUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DeleteBranchController {
    private final DeleteBranchUseCase deleteBranchUseCase;

    @DeleteMapping("/branch/{id}")
    @Transactional
    public ResponseEntity<BranchPublicDto> deleteBranch(@PathVariable Long id) throws BranchNotFoundException {
        var branch = new BranchPublicDto(deleteBranchUseCase.execute(id));
        return ResponseEntity.ok(branch);
    }
}
