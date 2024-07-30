package br.com.parkment.vehicle_control.infrastructure.config.db.repository;

import br.com.parkment.vehicle_control.infrastructure.config.db.schema.VehicleSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VehicleRepository extends JpaRepository<VehicleSchema, Long> {
    Optional<VehicleSchema> findByLicensePlate(String licensePlate);
}
