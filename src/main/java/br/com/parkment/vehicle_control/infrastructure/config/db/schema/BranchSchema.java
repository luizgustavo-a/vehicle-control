package br.com.parkment.vehicle_control.infrastructure.config.db.schema;

import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import jakarta.persistence.*;
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
@Table(name = "branches")
public class BranchSchema {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private AddressSchema address;

    @Pattern(regexp = "\\(?\\d{2}\\)?\\s?\\d{4,5}-?\\s?\\d{4}", message = "Please insert a valid telephone number.")
    private String contactNumber;

    @NotNull(message = "The number of parking spaces for cars must be provided.")
    private Integer numberOfCarSpaces;

    @NotNull(message = "The number of parking spaces for motorcycles must be provided.")
    private Integer numberOfMotorcycleSpaces;

    public BranchSchema(Branch branch) {
        this.id = branch.getId();
        this.address = new AddressSchema(branch.getAddress());
        this.contactNumber = branch.getContactNumber();
        this.numberOfCarSpaces = branch.getNumberOfCarSpaces();
        this.numberOfMotorcycleSpaces = branch.getNumberOfMotorcycleSpaces();
    }

    public Branch toModel() {
        return new Branch(
                this.id,
                this.address.toModel(),
                this.contactNumber,
                this.numberOfCarSpaces,
                this.numberOfMotorcycleSpaces
        );
    }
}
