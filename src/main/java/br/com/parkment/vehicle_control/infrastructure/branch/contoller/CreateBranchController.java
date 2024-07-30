package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchPublicDto;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchRegistrationDto;
import br.com.parkment.vehicle_control.usecases.branch.CreateBranchUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@AllArgsConstructor
@RestController
public class CreateBranchController {
    private final CreateBranchUseCase createBranchUseCase;

    @PostMapping("/branch")
    public ResponseEntity<BranchPublicDto> createBranch(@RequestBody BranchRegistrationDto data,
                                                        UriComponentsBuilder builder) {
        var branch = new BranchPublicDto(createBranchUseCase.execute(data));
        var uri = builder.path("/branch/{id}").buildAndExpand(branch.id()).toUri();

        return ResponseEntity.created(uri).body(branch);
    }
}
