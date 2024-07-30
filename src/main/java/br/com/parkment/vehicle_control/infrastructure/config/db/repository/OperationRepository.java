package br.com.parkment.vehicle_control.infrastructure.config.db.repository;

import br.com.parkment.vehicle_control.infrastructure.config.db.schema.OperationSchema;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OperationRepository extends JpaRepository <OperationSchema, UUID>{
}
