package br.com.parkment.vehicle_control.infrastructure.vehicle.gateway;

import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.VehicleRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.schema.VehicleSchema;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
public class VehicleDatabaseGateway implements VehicleGateway {
    private final VehicleRepository vehicleRepository;


    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(new VehicleSchema(vehicle)).toModel();
    }

    @Override
    public List<Vehicle> listAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(VehicleSchema::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> listVehiclesByType(VehicleType type) {
        return vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getType().equals(type))
                .map(VehicleSchema::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public List<Vehicle> listVehiclesByBranch(Long branchId) {
        return vehicleRepository.findAll()
                .stream()
                .filter(v -> v.getCurrentBranchId() != null && v.getCurrentBranchId().equals(branchId))
                .map(VehicleSchema::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Vehicle> searchVehicleById(Long id) {
        return vehicleRepository.findById(id).map(VehicleSchema::toModel);
    }

    @Override
    public Optional<Vehicle> searchVehicleByLicensePlate(String licensePlate) {
        return vehicleRepository.findByLicensePlate(licensePlate).map(VehicleSchema::toModel);
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle) {
        return vehicleRepository.save(new VehicleSchema(vehicle)).toModel();
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }
}
