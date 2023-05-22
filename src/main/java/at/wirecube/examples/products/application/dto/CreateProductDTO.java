package at.wirecube.examples.products.application.dto;

import at.wirecube.examples.products.application.enums.Vat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductDTO {

    @NotBlank
    private String name;
    @NotNull
    private double price;
    private String description;
    private Vat vat;
}
