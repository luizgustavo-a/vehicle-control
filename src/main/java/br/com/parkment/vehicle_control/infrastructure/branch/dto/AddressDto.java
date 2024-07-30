package br.com.parkment.vehicle_control.infrastructure.branch.dto;

import br.com.parkment.vehicle_control.entities.branch.model.Address;
import br.com.parkment.vehicle_control.usecases.branch.dto.IAddressDto;

public record AddressDto (
        String street,
        String number,
        String complement,
        String city,
        String state,
        String postalCode
) implements IAddressDto {
    public AddressDto (Address address){
        this(address.getStreet(), address.getNumber(), address.getComplement(),
                address.getCity(), address.getState(), address.getPostalCode());
    }
}
