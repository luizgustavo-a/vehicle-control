package br.com.parkment.vehicle_control.infrastructure.config.springdoc;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info()
                        .title("Parkment Vehicle Control API")
                        .description("API Rest for the management of Parkment's parking lots, containing CRUD functionalities related to the Branches and Vehicles " +
                                ", the operations of entrance and exit of vehicles from the Branches and reports of such operations.")
                        .contact(new Contact().email("luizalmeida.ads@gmail.com").url("https://github.com/luizgustavo-a"))
                        .license(new License().name("Apache 2.0").identifier("Apache-2.0"))
                        );

    }
}