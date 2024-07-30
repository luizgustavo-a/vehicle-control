package br.com.parkment.vehicle_control.infrastructure.branch.dto;

import br.com.parkment.vehicle_control.usecases.branch.dto.IBranchUpdateDto;

public record BranchUpdateDto(
        String id,
        AddressDto address,
        String contactNumber,
        String numberOfCarSpaces,
        String numberOfMotorcycleSpaces
) implements IBranchUpdateDto {
}
