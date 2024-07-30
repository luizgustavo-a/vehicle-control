package br.com.parkment.vehicle_control.usecases.operation.dto;

public interface IOperationDto {
    String id();
    String branchId();
    String vehicleId();
    String event();
    String timestamp();
}
