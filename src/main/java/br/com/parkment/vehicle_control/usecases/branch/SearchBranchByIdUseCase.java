package br.com.parkment.vehicle_control.usecases.branch;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.entities.branch.gateway.BranchGateway;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchBranchByIdUseCase {
    private final BranchGateway branchGateway;

    public Branch execute(Long id) throws BranchNotFoundException {
        return branchGateway.searchBranchById(id)
                .orElseThrow(BranchNotFoundException::new);
    }
}
