package com.JavaEE.netlib.security.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfiguration {
    @Bean
    public OpenAPI defineOpenApi() {
        Server server = new Server();
        server.setUrl("http://localhost:8081");
        server.setDescription("Development");

        Contact myContact = new Contact();
        myContact.setName("Sitchenko Anastasiya & Iminov Farukh");
        myContact.setEmail("mopsprivet@gmail.com, juiceeye@gmail.com");

        Info information = new Info()
                .title("NetLib Project API")
                .version("1.0")
                .description("This API exposes endpoints to manage a NetLib project")
                .contact(myContact);

        return new OpenAPI().info(information).servers(List.of(server));
    }
}
