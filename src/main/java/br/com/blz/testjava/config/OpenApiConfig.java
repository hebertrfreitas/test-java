package br.com.blz.testjava.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI configureOpenAPI(){

        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement().addList("bearerToken"))
                .components(
                        new Components()
                                .addSecuritySchemes("bearerToken",
                                     new SecurityScheme()
                                             .name("bearerToken")
                                             .type(SecurityScheme.Type.HTTP)
                                             .scheme("Bearer")
                                )
                ).info(new Info().title("Belezanaweb product api"));
    }



}
