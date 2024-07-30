package br.com.parkment.vehicle_control.entities.branch.gateway;

import br.com.parkment.vehicle_control.entities.branch.model.Branch;

import java.util.List;
import java.util.Optional;

public interface BranchGateway {
    Branch createBranch (Branch branch);

    List<Branch> listAllBranches();
    List<Branch> listBranchesByCity(String city);

    Optional<Branch> searchBranchById(Long id);

    Branch updateBranch(Branch branch);

    void deleteBranch(Long id);
}
