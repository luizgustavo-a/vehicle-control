package br.com.parkment.vehicle_control.infrastructure.config.db.schema;

import br.com.parkment.vehicle_control.entities.operation.model.Event;
import br.com.parkment.vehicle_control.entities.operation.model.Operation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "operations")
public class OperationSchema {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "branch_id")
    private BranchSchema branch;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleSchema vehicle;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Event event;

    @NotNull
    private Instant timestamp;

    public OperationSchema(Operation operation) {
        this(
                UUID.randomUUID(),
                new BranchSchema(operation.getBranchId()),
                new VehicleSchema(operation.getVehicleId()),
                operation.getEvent(),
                operation.getTimestamp()
        );
    }

    public Operation toModel() {
        return new Operation(
                this.getId().toString(),
                this.getBranch().toModel(),
                this.getVehicle().toModel(),
                this.getEvent(),
                this.getTimestamp()
        );
    }

}
