package br.com.parkment.vehicle_control.entities.branch.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Branch {
    private Long id;
    private Address address;
    private String contactNumber;
    private Integer numberOfCarSpaces;
    private Integer numberOfMotorcycleSpaces;

    public Branch() {}

    public Branch(Address address, String contactNumber, Integer numberOfCarSpaces, Integer numberOfMotorcycleSpaces) {
        this.address = address;
        this.contactNumber = contactNumber;
        this.numberOfCarSpaces = numberOfCarSpaces;
        this.numberOfMotorcycleSpaces = numberOfMotorcycleSpaces;
    }

    public Branch(Long id, Address address, String contactNumber, Integer numberOfCarSpaces, Integer numberOfMotorcycleSpaces) {
        this.id = id;
        this.address = address;
        this.contactNumber = contactNumber;
        this.numberOfCarSpaces = numberOfCarSpaces;
        this.numberOfMotorcycleSpaces = numberOfMotorcycleSpaces;
    }

}
