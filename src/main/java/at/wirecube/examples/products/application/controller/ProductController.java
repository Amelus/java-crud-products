package at.wirecube.examples.products.application.controller;

import at.wirecube.examples.products.application.dto.CreateProductDTO;
import at.wirecube.examples.products.application.dto.ProductDTO;
import at.wirecube.examples.products.application.dto.ProductListResponse;
import at.wirecube.examples.products.application.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ProductListResponse getAllProducts() {
        return ProductListResponse.builder()
                .products(productService.getAllProducts())
                .build();
    }

    @GetMapping("/{productId}")
    public ProductDTO getProduct(@RequestParam("productId") String productId) {
        ProductDTO product = productService.getProduct(productId);
        if (product != null) {
            return product;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ProductDTO createProduct(@RequestBody @Valid CreateProductDTO createProductDTO) {
        return productService.createProduct(createProductDTO);
    }

    @PutMapping
    @PreAuthorize("hasRole('ROLE_USER')")
    public ProductDTO updateProduct() {
        return null;
    }

    @DeleteMapping("/{productId}")
    @PreAuthorize("hasRole('ROLE_USER')")
    public void deleteProduct(@RequestParam("productId") String productId) {

    }
}
