package br.com.parkment.vehicle_control.entities.branch.model;

import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Branch {
    private Long id;
    private Address address;
    private String contactNumber;
    private Integer numberOfCarSpaces;
    private Integer numberOfMotorcycleSpaces;
    private List<Vehicle> vehicles;

    public Branch() {}

    public Branch(Address address, String contactNumber, Integer numberOfCarSpaces, Integer numberOfMotorcycleSpaces) {
        this.address = address;
        this.contactNumber = contactNumber;
        this.numberOfCarSpaces = numberOfCarSpaces;
        this.numberOfMotorcycleSpaces = numberOfMotorcycleSpaces;
    }

    public Branch(Long id, Address address, String contactNumber, Integer numberOfCarSpaces, Integer numberOfMotorcycleSpaces, List<Vehicle> vehicles) {
        this.id = id;
        this.address = address;
        this.contactNumber = contactNumber;
        this.numberOfCarSpaces = numberOfCarSpaces;
        this.numberOfMotorcycleSpaces = numberOfMotorcycleSpaces;
        this.vehicles = vehicles;
    }

}
