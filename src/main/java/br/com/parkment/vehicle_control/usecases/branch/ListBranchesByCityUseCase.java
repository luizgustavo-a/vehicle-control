package br.com.parkment.vehicle_control.usecases.branch;

import br.com.parkment.vehicle_control.entities.branch.gateway.BranchGateway;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class ListBranchesByCityUseCase {
    private final BranchGateway branchGateway;

    public List<Branch> execute(String city) {
        return branchGateway.listBranchesByCity(city);
    }
}
