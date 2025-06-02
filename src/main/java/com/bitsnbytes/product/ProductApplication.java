package com.bitsnbytes.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service REST API Documentation",
				description = "Product Service REST API",
				version = "v1",
				contact = @Contact(
						name = "Raj Kumar",
						email = "rajkumar209@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Sharepoint URL Product Service API",
				url = "example.com"
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductApplication.class, args);
	}
}
