package br.com.parkment.vehicle_control.usecases.branch;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.entities.branch.gateway.BranchGateway;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.usecases.branch.dto.IBranchUpdateDto;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class UpdateBranchUseCase {
    private final BranchGateway branchGateway;

    public Branch execute(IBranchUpdateDto data) throws BranchNotFoundException {
        Branch branch = branchGateway.searchBranchById(Long.parseLong(data.id()))
                .orElseThrow(BranchNotFoundException::new);

        if(data.address() != null) {
            if (data.address().street() != null && !data.address().street().isBlank()) {
                branch.getAddress().setStreet(data.address().street());
            }
            if (data.address().number() != null && !data.address().number().isBlank()) {
                branch.getAddress().setNumber(data.address().number());
            }
            if (data.address().complement() != null && !data.address().complement().isBlank()) {
                branch.getAddress().setComplement(data.address().complement());
            }
            if (data.address().city() != null && !data.address().city().isBlank()) {
                branch.getAddress().setCity(data.address().city());
            }
            if (data.address().state() != null && !data.address().state().isBlank()) {
                branch.getAddress().setState(data.address().state());
            }
            if (data.address().postalCode() != null && !data.address().postalCode().isBlank()) {
                branch.getAddress().setPostalCode(data.address().postalCode());
            }
        }
        if(data.contactNumber() != null && !data.contactNumber().isBlank()) {
            branch.setContactNumber(data.contactNumber());
        }
        if(data.numberOfCarSpaces() != null && !data.numberOfCarSpaces().isBlank()) {
            branch.setNumberOfCarSpaces(Integer.parseInt(data.numberOfCarSpaces()));
        }
        if(data.numberOfMotorcycleSpaces() != null && !data.numberOfMotorcycleSpaces().isBlank()) {
            branch.setNumberOfMotorcycleSpaces(Integer.parseInt(data.numberOfMotorcycleSpaces()));
        }

        return branchGateway.updateBranch(branch);
    }
}
