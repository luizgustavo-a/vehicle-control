package br.com.parkment.vehicle_control.infrastructure.config.db.repository;

import br.com.parkment.vehicle_control.infrastructure.config.db.schema.BranchSchema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchRepository extends JpaRepository<BranchSchema, Long> {
}
