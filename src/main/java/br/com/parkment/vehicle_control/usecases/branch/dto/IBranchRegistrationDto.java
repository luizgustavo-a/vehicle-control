package br.com.parkment.vehicle_control.usecases.branch.dto;

public interface IBranchRegistrationDto {
    IAddressDto address();
    String contactNumber();
    String numberOfCarSpaces();
    String numberOfMotorcycleSpaces();
}
