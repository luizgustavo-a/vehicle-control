package br.com.parkment.vehicle_control.entities.operation.exception;

public class OperationNotFoundException extends Exception {
    public OperationNotFoundException() {
        super("Operation not found.");
    }
}
