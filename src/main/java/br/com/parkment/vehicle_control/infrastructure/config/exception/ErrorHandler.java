package br.com.parkment.vehicle_control.infrastructure.config.exception;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.entities.operation.exception.InvalidOperationException;
import br.com.parkment.vehicle_control.entities.operation.exception.OperationNotFoundException;
import br.com.parkment.vehicle_control.entities.vehicle.exception.VehicleNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity handleError404(EntityNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(BranchNotFoundException.class)
    public ResponseEntity handlePlanetNotFoundException(BranchNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(VehicleNotFoundException.class)
    public ResponseEntity handlePlanetNotFoundException(VehicleNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(OperationNotFoundException.class)
    public ResponseEntity handlePlanetNotFoundException(OperationNotFoundException e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity handlerError400(MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getFieldErrors();

        List<ValidationErrorData> messages = new ArrayList<>(errors.size());
        errors.forEach(error -> {
            if(messages.stream().anyMatch(validationErrorData -> Objects.equals(validationErrorData.field(), error.getField()))) {
                ValidationErrorData data = messages.stream().filter(validationErrorData ->
                        Objects.equals(validationErrorData.field(), error.getField())
                ).findFirst().get();

                messages.remove(data);
                List<String> messageList = data.messages();
                String errorMessage = error.getDefaultMessage();
                messageList.add(errorMessage);
                messages.add(new ValidationErrorData(error.getField(), messageList));
            } else {
                messages.add(new ValidationErrorData(error));
            }
        });

        return ResponseEntity.badRequest().body(messages);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity handleError400(HttpMessageNotReadableException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(InvalidOperationException.class)
    public ResponseEntity handleError400(InvalidOperationException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleError500(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    }

    @ExceptionHandler(JpaSystemException.class)
    public ResponseEntity handleError500(JpaSystemException e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getLocalizedMessage());
    }

    private record ValidationErrorData(
            String field,
            List<String> messages
    ) {
        public ValidationErrorData(FieldError error) {
            this(error.getField(), new ArrayList<>(Collections.singletonList(error.getDefaultMessage())));
        }
    }
}