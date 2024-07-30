package br.com.parkment.vehicle_control.infrastructure.branch.contoller;

import br.com.parkment.vehicle_control.entities.branch.model.Address;
import br.com.parkment.vehicle_control.entities.branch.model.Branch;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.AddressDto;
import br.com.parkment.vehicle_control.infrastructure.branch.dto.BranchRegistrationDto;
import br.com.parkment.vehicle_control.infrastructure.config.db.repository.BranchRepository;
import br.com.parkment.vehicle_control.usecases.branch.CreateBranchUseCase;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CreateBranchController.class)
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
class CreateBranchControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CreateBranchUseCase useCase;

    @MockBean
    private BranchRepository repository;

    @Test
    void shouldBeCode201Created() throws Exception {
        String json = """
            {
                "address": {
                    "street": "rua",
                    "number": "1",
                    "complement": "sd",
                    "city": "cidade",
                    "state": "estado",
                    "postalCode": "12345678"
                },
                "contactNumber": "(11)11111111",
                "numberOfCarSpaces": "50",
                "numberOfMotorcycleSpaces": "10"
            }
            """;

        var branch = new BranchRegistrationDto(
                new AddressDto("rua", "1", "sd", "cidade", "estado", "12345678"),
                "(11)11111111", "50", "10"
        );

        var address = new Address("rua", "1", "sd", "cidade", "estado", "12345678");
        var branchResult = new Branch();
        branchResult.setAddress(address);
        branchResult.setNumberOfCarSpaces(50);

        when(useCase.execute(branch)).thenReturn(branchResult);

        mvc.perform(
                post("/branch")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isCreated())
                .andExpect(jsonPath("address.street").value("rua"))
                .andExpect(jsonPath("numberOfCarSpaces").value(50));
    }

    @Test
    void shouldBeCode500ServerError() throws Exception {
        String json = """
            {

            }
            """;

        mvc.perform(
                post("/branch")
                        .content(json)
                        .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isInternalServerError());
    }

}