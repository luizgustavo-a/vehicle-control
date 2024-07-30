package br.com.parkment.vehicle_control.infrastructure.branch.dto;

import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.usecases.branch.dto.IBranchPublicDto;

public record BranchPublicDto (
        String id,
        AddressDto address,
        String contactNumber,
        String numberOfCarSpaces,
        String numberOfMotorcycleSpaces
) implements IBranchPublicDto {

    public BranchPublicDto(Branch branch) {
        this(
                String.valueOf(branch.getId()),
                new AddressDto(branch.getAddress()),
                branch.getContactNumber(),
                String.valueOf(branch.getNumberOfCarSpaces()),
                String.valueOf(branch.getNumberOfMotorcycleSpaces())
        );
    }
}
