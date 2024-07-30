package br.com.parkment.vehicle_control.usecases.operation;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.entities.operation.exception.InvalidOperationException;
import br.com.parkment.vehicle_control.entities.operation.gateway.OperationGateway;
import br.com.parkment.vehicle_control.entities.operation.model.Event;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.gateway.VehicleGateway;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;
import br.com.parkment.vehicle_control.usecases.branch.SearchBranchByIdUseCase;
import br.com.parkment.vehicle_control.usecases.vehicle.dto.IVehicleRegistrationData;
import lombok.AllArgsConstructor;

import java.time.Instant;

@AllArgsConstructor
public class EnterVehicleToBranchUseCase {
    private final OperationGateway operationGateway;
    private final VehicleGateway vehicleGateway;
    private final SearchBranchByIdUseCase searchBranchByIdUseCase;

    public Operation execute(Long branchId, Long vehicleId) throws VehicleNotFoundException, BranchNotFoundException,
            InvalidOperationException {
        Vehicle vehicle = vehicleGateway.searchVehicleById(vehicleId)
                .orElseThrow(VehicleNotFoundException::new);
        Branch branch = searchBranchByIdUseCase.execute(branchId);

        return enterVehicle(branch, vehicle);
    }

    public Operation execute(Long branchId, IVehicleRegistrationData data) throws BranchNotFoundException,
            InvalidOperationException {
        Branch branch = searchBranchByIdUseCase.execute(branchId);
        var savedVehicle = vehicleGateway.createVehicle(new Vehicle(data.brand(), data.model(), data.color(), data.licensePlate(),
                VehicleType.fromString(data.type())));

        return enterVehicle(branch, savedVehicle);
    }

    private boolean isCarFull (Branch branch) {
        var carNumber = vehicleGateway.listVehiclesByBranch(branch.getId())
                .stream()
                .filter(v -> v.getType() == VehicleType.CAR)
                .toList()
                .size();

        return carNumber >= branch.getNumberOfCarSpaces();
    }

    private boolean isMotorcycleFull (Branch branch) {
        var motorcycleNumber = vehicleGateway.listVehiclesByBranch(branch.getId())
                .stream()
                .filter(v -> v.getType() == VehicleType.MOTORCYCLE)
                .toList()
                .size();

        return motorcycleNumber >= branch.getNumberOfMotorcycleSpaces();
    }

    private Operation enterVehicle(Branch branch, Vehicle vehicle) throws InvalidOperationException {
        var lastOperation = operationGateway.searchLastOperationOfAVehicle(vehicle.getId());

        boolean isVehicleItAlreadyParked = lastOperation.isPresent() && lastOperation.get().getEvent() == Event.ENTRY;
        boolean isThereParkingSpace = vehicle.getType() == VehicleType.CAR && !isCarFull(branch)
                || vehicle.getType() == VehicleType.MOTORCYCLE && !isMotorcycleFull(branch);

        if (!isVehicleItAlreadyParked && isThereParkingSpace) {
            vehicle.setCurrentBranchId(branch.getId());
            vehicleGateway.updateVehicle(vehicle);

            Operation operation =  new Operation(branch, vehicle, Event.ENTRY,
                    Instant.now());

            return operationGateway.enterVehicle(operation);
        }

        throw new InvalidOperationException();
    }
}
