package br.com.parkment.vehicle_control.entities.operation.model;

import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
public class Operation {
    private String id;
    private Branch branchId;
    private Vehicle vehicleId;
    private Event event;
    private Instant timestamp;

    public Operation(Branch branchId, Vehicle vehicleId, Event event, Instant timestamp) {
        this.branchId = branchId;
        this.vehicleId = vehicleId;
        this.event = event;
        this.timestamp = timestamp;
    }

}
