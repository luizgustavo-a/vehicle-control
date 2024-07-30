package br.com.parkment.vehicle_control.usecases.branch.dto;

public interface IBranchPublicDto {
    String id();
    IAddressDto address();
    String contactNumber();
    String numberOfCarSpaces();
    String numberOfMotorcycleSpaces();
}
