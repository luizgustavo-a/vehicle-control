package br.com.parkment.vehicle_control.infrastructure.branch.dto;

import br.com.parkment.vehicle_control.usecases.branch.dto.IBranchRegistrationDto;

public record BranchRegistrationDto (
        AddressDto address,
        String contactNumber,
        String numberOfCarSpaces,
        String numberOfMotorcycleSpaces
) implements IBranchRegistrationDto {
}
