package at.wirecube.examples.products.application;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "at.wirecube.examples.products.application.repository")
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Products API", version = "1.0", description = "Sample Product Management Api by Amel H."))
public class ProductManagementApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ProductManagementApplication.class, args);
    }
}
