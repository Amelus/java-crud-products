package at.wirecube.examples.products.application.dto;

import at.wirecube.examples.products.application.enums.Vat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private int id;
    private String name;
    private double price;
    private String description;
    private Vat vat;
}
