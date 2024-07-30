package br.com.parkment.vehicle_control.usecases.branch;

import br.com.parkment.vehicle_control.entities.branch.gateway.BranchGateway;
import br.com.parkment.vehicle_control.entities.branch.model.Address;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.usecases.branch.dto.IBranchRegistrationDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateBranchUseCase {
    public final BranchGateway branchGateway;

    public Branch execute(IBranchRegistrationDto data) {
        Branch branch = new Branch(
                new Address(data.address().street(), data.address().number(),
                data.address().complement(), data.address().city(), data.address().state(),
                data.address().postalCode()),
                data.contactNumber(),
                Integer.parseInt(data.numberOfCarSpaces()),
                Integer.parseInt(data.numberOfMotorcycleSpaces())
        );

        return branchGateway.createBranch(branch);
    }
}
