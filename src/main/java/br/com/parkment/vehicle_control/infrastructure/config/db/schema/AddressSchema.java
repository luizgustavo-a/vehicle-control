package br.com.parkment.vehicle_control.infrastructure.config.db.schema;

import br.com.parkment.vehicle_control.entities.branch.model.Address;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Embeddable
public class AddressSchema {
    @NotBlank(message = "Please specify the street name.")
    private String street;

    @NotBlank(message = "Please specify the address number or fill with S/N.")
    private String number;

    private String complement;

    @NotBlank(message = "Please specify the city.")
    private String city;

    @NotBlank(message = "Please specify the state.")
    private String state;

    @Pattern(regexp = "^\\d{5}[-\\s]?\\d{3}$", message = "Please insert a valid CEP.")
    private String postalCode;

    public AddressSchema (Address address) {
        this(
                address.getStreet(),
                address.getNumber(),
                address.getComplement(),
                address.getCity(),
                address.getState(),
                address.getPostalCode()
        );
    }

    public Address toModel() {
        return new Address(
                this.street,
                this.number,
                this.complement,
                this.city,
                this.state,
                this.postalCode
        );
    }
}
