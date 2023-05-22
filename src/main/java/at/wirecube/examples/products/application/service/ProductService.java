package at.wirecube.examples.products.application.service;

import at.wirecube.examples.products.application.converter.ProductConverter;
import at.wirecube.examples.products.application.dto.CreateProductDTO;
import at.wirecube.examples.products.application.dto.ProductDTO;
import at.wirecube.examples.products.application.repository.ProductRepository;
import at.wirecube.examples.products.application.repository.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductConverter productConverter;

    @NonNull
    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                .map(productConverter::convert)
                .toList();
    }

    @Nullable
    public ProductDTO getProduct(@NonNull String id) {
        Assert.hasText(id, "id must not be empty");
        Optional<Product> productEntity = productRepository.findById(id);
        return productEntity.map(productConverter::convert).orElse(null);
    }

    @Nullable
    public ProductDTO createProduct(CreateProductDTO createProductDTO) {
        return null;
    }

    @Nullable
    public ProductDTO updateProduct(){
        return null;
    }


}
