package at.wirecube.examples.products.application.converter;

import at.wirecube.examples.products.application.dto.ProductDTO;
import at.wirecube.examples.products.application.repository.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter implements Converter<Product, ProductDTO> {
    @Override
    public ProductDTO convert(Product source) {
        return ProductDTO.builder()
                .id(source.getId())
                .name(source.getName())
                .price(source.getPrice())
                .description(source.getDescription())
                .vat(source.getVat())
                .build();
    }
}
