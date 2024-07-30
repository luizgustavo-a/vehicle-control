package br.com.parkment.vehicle_control.infrastructure.config.db.schema;

import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import br.com.parkment.vehicle_control.entities.vehicle.model.VehicleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vehicles")
public class VehicleSchema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Please specify the vehicle brand.")
    private String brand;

    @NotBlank(message = "Please specify the vehicle model.")
    private String model;

    @NotBlank(message = "Please specify the vehicle color.")
    private String color;

    @Pattern(regexp = "^[A-Z]{3}[- ]?[0-9]{1}[A-Z0-9]{1}[0-9]{2}$", message = "Please insert a valid license plate.")
    @Column(unique = true)
    private String licensePlate;

    @NotNull(message = "Please specify the vehicle type.")
    @Enumerated(EnumType.STRING)
    private VehicleType type;

    private Long currentBranchId;

    public VehicleSchema(Vehicle vehicle) {
        this(
                vehicle.getId(),
                vehicle.getBrand(),
                vehicle.getModel(),
                vehicle.getColor(),
                vehicle.getLicensePlate(),
                vehicle.getType(),
                vehicle.getCurrentBranchId()
        );
    }

    public Vehicle toModel() {
        return new Vehicle(
                this.id,
                this.brand,
                this.model,
                this.color,
                this.licensePlate,
                this.type,
                this.currentBranchId
        );
    }

}
