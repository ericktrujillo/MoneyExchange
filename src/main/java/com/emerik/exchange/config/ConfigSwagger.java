package com.emerik.exchange.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigSwagger {

    @Bean
    OpenAPI api(){
        return new OpenAPI()
                .info(
                        new Info().title("My ExchangeApplication")
                                .version("1.0")
                                .description("Documentation for ExchangeApp ver.1.0")
                );
    }
}
