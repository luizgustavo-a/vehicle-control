package br.com.parkment.vehicle_control.entities.branch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private String street;
    private String number;
    private String complement;
    private String city;
    private String state;
    private String postalCode;

    private Address() {}

    public Address(String street, String number, String complement, String city, String state, String postalCode) {
        this.street = street;
        this.number = number;
        this.complement = complement;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

}
