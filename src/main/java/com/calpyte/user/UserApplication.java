package com.calpyte.user;

import com.keycloak.connector.config.EnableKeycloak;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@EnableKeycloak
@EnableWebMvc
@OpenAPIDefinition(info = @Info(title = "Traceability API", version = "2.0", description = "Traceability Information"))
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class UserApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${openapi.service.title}") String serviceTitle, @Value("${openapi.service.version}") String serviceVersion) {
		final String securitySchemeName = "bearerAuth";
		List list = new ArrayList();
		list.add(new SecurityRequirement().addList(securitySchemeName));

		return new OpenAPI()
				.components(
						new Components()
								.addSecuritySchemes(securitySchemeName,
										new SecurityScheme()
												.type(SecurityScheme.Type.HTTP)
												.scheme("bearer")
												.bearerFormat("JWT")
								)
				)
				.security(list)
				.info(new io.swagger.v3.oas.models.info.Info().title(serviceTitle).version(serviceVersion));
	}
}
