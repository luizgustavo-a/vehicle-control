package br.com.parkment.vehicle_control.usecases.branch.dto;

public interface IBranchUpdateDto {
    String id();
    IAddressDto address();
    String contactNumber();
    String numberOfCarSpaces();
    String numberOfMotorcycleSpaces();
}
