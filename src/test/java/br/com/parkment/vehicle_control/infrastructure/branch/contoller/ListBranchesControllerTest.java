package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.model.Address;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.BranchRepository;
import br.com.parkment.vehicle_control.infrastructure.config.db.schema.BranchSchema;
import br.com.parkment.vehicle_control.usecases.branch.CreateBranchUseCase;
import br.com.parkment.vehicle_control.usecases.branch.ListAllBranchesUseCase;
import br.com.parkment.vehicle_control.usecases.branch.ListBranchesByCityUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(ListBranchesController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class ListBranchesControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ListAllBranchesUseCase listAllBranchesUseCase;

    @MockBean
    private ListBranchesByCityUseCase listBranchesByCityUseCase;

    @MockBean
    private BranchRepository repository;

    @Test
    void shouldBe200() throws Exception {

        Branch branch1 = new Branch(new Address("a", "a", "a", "a", "a", "12345678"), "11111111111", 10, 10);
        Branch branch2 = new Branch(new Address("b", "a", "a", "a", "a", "12345678"), "22222222222", 10, 10);;

        repository.save(new BranchSchema(branch1));
        repository.save(new BranchSchema(branch2));

        List<Branch> branchList = new ArrayList<>();
        branchList.add(branch1);
        branchList.add(branch2);

        when(listAllBranchesUseCase.execute()).thenReturn(branchList);

        mvc.perform(
                get("/branch")
        ).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].address.street").value("a"))
                .andExpect(jsonPath("$[1].address.street").value("b"))
                .andExpect(jsonPath("$[0].contactNumber").value("11111111111"))
                .andExpect(jsonPath("$[1].contactNumber").value("22222222222"));
    }

    @Test
    void shouldBe200WithCityParam() throws Exception {

        Branch branch1 = new Branch(new Address("a", "a", "a", "city", "a", "12345678"), "11111111111", 10, 10);
        Branch branch2 = new Branch(new Address("b", "a", "a", "a", "a", "12345678"), "22222222222", 10, 10);;

        repository.save(new BranchSchema(branch1));
        repository.save(new BranchSchema(branch2));

        List<Branch> branchList = new ArrayList<>();
        branchList.add(branch1);

        when(listBranchesByCityUseCase.execute("city")).thenReturn(branchList);

        mvc.perform(
                        get("/branch").param("city", "city")
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].address.street").value("a"));
    }
}