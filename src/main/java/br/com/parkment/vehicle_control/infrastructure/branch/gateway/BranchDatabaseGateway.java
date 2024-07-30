package br.com.parkment.vehicle_control.infrastructure.branch.gateway;

import br.com.parkment.vehicle_control.entities.branch.gateway.BranchGateway;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.BranchRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.schema.BranchSchema;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class BranchDatabaseGateway implements BranchGateway {
    private final BranchRepository branchRepository;

    @Override
    public Branch createBranch(Branch branch) {
        return branchRepository.save(new BranchSchema(branch)).toModel();
    }

    @Override
    public List<Branch> listAllBranches() {
        return branchRepository.findAll()
                .stream()
                .map(BranchSchema::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Branch> listBranchesByCity(String city) {
        return branchRepository.findAll()
                .stream()
                .filter(b -> b.getAddress().getCity().equalsIgnoreCase(city))
                .map(BranchSchema::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Branch> searchBranchById(Long id) {
        return branchRepository.findById(id)
                .map(BranchSchema::toModel);
    }

    @Override
    public Branch updateBranch(Branch branch) {
        return branchRepository.save(new BranchSchema(branch)).toModel();
    }

    @Override
    public void deleteBranch(Long id) {
        branchRepository.deleteById(id);
    }
}
