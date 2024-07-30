package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchPublicDto;
import br.com.parkment.vehicle_control.usecases.branch.ListAllBranchesUseCase;
import br.com.parkment.vehicle_control.usecases.branch.ListBranchesByCityUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class ListBranchesController {
    private final ListAllBranchesUseCase listAllBranchesUseCase;
    private final ListBranchesByCityUseCase listBranchesByCityUseCase;

    @GetMapping("/branch")
    public ResponseEntity<List<BranchPublicDto>> listBranches(@RequestParam(required = false) String city) {
        List<BranchPublicDto> listBranches;

        if (city == null || city.isBlank()) {
            listBranches = listAllBranchesUseCase.execute()
                    .stream()
                    .map(BranchPublicDto::new)
                    .toList();
        } else {
            listBranches = listBranchesByCityUseCase.execute(city)
                    .stream()
                    .map(BranchPublicDto::new)
                    .toList();
        }

        return ResponseEntity.ok(listBranches);
    }
}
