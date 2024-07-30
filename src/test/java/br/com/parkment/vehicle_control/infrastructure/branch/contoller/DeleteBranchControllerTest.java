package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.exception.BranchNotFoundException;
import br.com.parkment.vehicle_control.entities.branch.model.Address;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.AddressDto;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchRegistrationDto;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.BranchRepository;
import br.com.parkment.vehicle_control.usecases.branch.CreateBranchUseCase;
import br.com.parkment.vehicle_control.usecases.branch.DeleteBranchUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DeleteBranchController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class DeleteBranchControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private DeleteBranchUseCase useCase;

    @MockBean
    private BranchRepository repository;

    @Test
    void shouldBeCode200Ok() throws Exception {
        var address = new Address("rua", "1", "sd", "cidade", "estado", "12345678");
        var branchResult = new Branch();
        branchResult.setAddress(address);

        when(useCase.execute(1L)).thenReturn(branchResult);

        mvc.perform(
                delete("/branch/1")
        ).andExpect(status().isOk());
    }

    @Test
    void shouldBeCode404NotFound() throws Exception {
        when(useCase.execute(1L)).thenThrow(BranchNotFoundException.class);

        mvc.perform(
                delete("/branch/1")
        ).andExpect(status().isNotFound());
    }
}