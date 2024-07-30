package br.com.parkment.vehicle_control.entities.operation.exception;

public class InvalidOperationException extends Exception{
    public InvalidOperationException() {
        super("Invalid operation.");
    }
}
