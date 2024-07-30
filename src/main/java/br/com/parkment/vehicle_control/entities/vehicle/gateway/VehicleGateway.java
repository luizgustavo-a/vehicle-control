package br.com.parkment.vehicle_control.entities.vehicle.gateway;

import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;

import java.util.List;
import java.util.Optional;

public interface VehicleGateway {
    Vehicle createVehicle(Vehicle vehicle);

    List<Vehicle> listAllVehicles();
    List<Vehicle> listVehiclesByType(VehicleType type);
    List<Vehicle> listVehiclesByBranch(Long branchId);

    Optional<Vehicle> searchVehicleById(Long id);
    Optional<Vehicle> searchVehicleByLicensePlate(String licensePlate);

    Vehicle updateVehicle(Vehicle vehicle);

    void deleteVehicle(Long id);
}
