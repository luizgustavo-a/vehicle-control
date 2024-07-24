package br.com.parkment.vehicle_control.entities.branch.model;

import br.com.parkment.vehicle_control.entities.vehicle.model.Vehicle;

import java.util.List;

public class Branch {
    private Long id;
    private Address address;
    private String contactNumber;
    private Integer numberOfCarSpaces;
    private Integer numberOfMotorcycleSpaces;
    private List<Vehicle> vehicles;

    public Branch() {}

    public Branch(Long id, Address address, String contactNumber, Integer numberOfCarSpaces, Integer numberOfMotorcycleSpaces, List<Vehicle> vehicles) {
        this.id = id;
        this.address = address;
        this.contactNumber = contactNumber;
        this.numberOfCarSpaces = numberOfCarSpaces;
        this.numberOfMotorcycleSpaces = numberOfMotorcycleSpaces;
        this.vehicles = vehicles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Integer getNumberOfCarSpaces() {
        return numberOfCarSpaces;
    }

    public void setNumberOfCarSpaces(Integer numberOfCarSpaces) {
        this.numberOfCarSpaces = numberOfCarSpaces;
    }

    public Integer getNumberOfMotorcycleSpaces() {
        return numberOfMotorcycleSpaces;
    }

    public void setNumberOfMotorcycleSpaces(Integer numberOfMotorcycleSpaces) {
        this.numberOfMotorcycleSpaces = numberOfMotorcycleSpaces;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }
}
