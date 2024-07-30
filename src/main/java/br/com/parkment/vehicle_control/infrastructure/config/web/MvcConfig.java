package br.com.parkment.vehicle_control.infrastructure.config.web;

import br.com.parkment.vehicle_control.infrastructure.branch.gateway.BranchDatabaseGateway;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.BranchRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.OperationRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.VehicleRepository;
import br.com.parkment.vehicle_control.infrastructure.operation.gateway.OperationsDatabaseGateway;
import br.com.parkment.vehicle_control.infrastructure.vehicle.gateway.VehicleDatabaseGateway;
import br.com.parkment.vehicle_control.usecases.branch.*;
import br.com.parkment.vehicle_control.usecases.operation.*;
import br.com.parkment.vehicle_control.usecases.vehicle.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MvcConfig {

    @Bean
    public CreateBranchUseCase createBranchUseCase(BranchRepository branchRepository) {
        return new CreateBranchUseCase(new BranchDatabaseGateway(branchRepository));
    }

    @Bean
    public DeleteBranchUseCase deleteBranchUseCase(BranchRepository branchRepository) {
        return new DeleteBranchUseCase(new BranchDatabaseGateway(branchRepository));
    }

    @Bean
    public ListAllBranchesUseCase listAllBranchesUseCase(BranchRepository branchRepository) {
        return new ListAllBranchesUseCase(new BranchDatabaseGateway(branchRepository));
    }

    @Bean
    public SearchBranchByIdUseCase searchBranchByIdUseCase(BranchRepository branchRepository) {
        return new SearchBranchByIdUseCase(new BranchDatabaseGateway(branchRepository));
    }

    @Bean
    public UpdateBranchUseCase updateBranchUseCase(BranchRepository branchRepository) {
        return new UpdateBranchUseCase(new BranchDatabaseGateway(branchRepository));
    }

    @Bean
    public ListBranchesByCityUseCase listBranchesByCityUseCase(BranchRepository branchRepository) {
        return new ListBranchesByCityUseCase(new BranchDatabaseGateway(branchRepository));
    }

    @Bean
    public CreateVehicleUseCase createVehicleUseCase(VehicleRepository vehicleRepository) {
        return new CreateVehicleUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public DeleteVehicleUseCase deleteVehicleUseCase(VehicleRepository vehicleRepository) {
        return new DeleteVehicleUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public ListAllVehiclesUseCase listAllVehiclesUseCase(VehicleRepository vehicleRepository) {
        return new ListAllVehiclesUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public ListVehiclesByTypeUseCase listVehiclesByTypeUseCase(VehicleRepository vehicleRepository) {
        return new ListVehiclesByTypeUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public ListVehicleByBranchUseCase listVehicleByBranchUseCase(VehicleRepository vehicleRepository) {
        return new ListVehicleByBranchUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public SearchVehicleByIdUseCase searchVehicleByIdUseCase(VehicleRepository vehicleRepository) {
        return new SearchVehicleByIdUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public SearchVehicleByLicencePlateUseCase searchVehicleByLicencePlateUseCase(VehicleRepository vehicleRepository) {
        return new SearchVehicleByLicencePlateUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public UpdateVehicleUseCase updateVehicleUseCase(VehicleRepository vehicleRepository) {
        return new UpdateVehicleUseCase(new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public SearchLastOperationOfAVehicleUseCase searchLastOperationOfAVehicleUseCase(OperationRepository operationRepository) {
        return new SearchLastOperationOfAVehicleUseCase(new OperationsDatabaseGateway(operationRepository));
    }

    @Bean
    public SearchOperationByIdUseCase searchOperationByIdUseCase(OperationRepository operationRepository) {
        return new SearchOperationByIdUseCase(new OperationsDatabaseGateway(operationRepository));
    }

    @Bean
    public EnterVehicleToBranchUseCase enterVehicleToBranchUseCase(OperationRepository operationRepository,
                                                                   VehicleRepository vehicleRepository, BranchRepository branchRepository) {
        return new EnterVehicleToBranchUseCase(new OperationsDatabaseGateway(operationRepository), new VehicleDatabaseGateway(vehicleRepository),
                searchBranchByIdUseCase(branchRepository));
    }

    @Bean
    public ExitVehicleFromBranchUseCase exitVehicleFromBranchUseCase(OperationRepository operationRepository, VehicleRepository vehicleRepository) {
        return new ExitVehicleFromBranchUseCase(new OperationsDatabaseGateway(operationRepository), new VehicleDatabaseGateway(vehicleRepository));
    }

    @Bean
    public ListAllOperationsUseCase listAllOperationsUseCase(OperationRepository operationRepository) {
        return new ListAllOperationsUseCase(new OperationsDatabaseGateway(operationRepository));
    }
}
