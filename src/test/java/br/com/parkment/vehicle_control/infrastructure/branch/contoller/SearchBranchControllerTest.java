package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.model.Address;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.BranchRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.schema.BranchSchema;
import br.com.parkment.vehicle_control.usecases.branch.ListAllBranchesUseCase;
import br.com.parkment.vehicle_control.usecases.branch.ListBranchesByCityUseCase;
import br.com.parkment.vehicle_control.usecases.branch.SearchBranchByIdUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SearchBranchController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class SearchBranchControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private SearchBranchByIdUseCase useCase;

    @MockBean
    private BranchRepository repository;

    @Test
    void shouldBe200() throws Exception {
        Branch branch = new Branch(new Address("a", "a", "a", "a", "a", "12345678"), "11111111111", 10, 10);

        var savedBranch = new BranchSchema(branch);
        repository.save(savedBranch);
        savedBranch.setId(1L);

        when(useCase.execute(1L)).thenReturn(branch);

        mvc.perform(
                        get("/branch/1")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("contactNumber").value("11111111111"));
    }
}