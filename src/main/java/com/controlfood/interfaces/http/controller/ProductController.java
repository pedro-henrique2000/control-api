package com.controlfood.interfaces.http.controller;

import com.controlfood.application.product.CreateProduct;
import com.controlfood.application.product.FindAllProducts;
import com.controlfood.application.product.FindProductById;
import com.controlfood.domain.entities.Product;
import com.controlfood.interfaces.http.controller.api.ProductControllerApi;
import com.controlfood.interfaces.http.dto.ProductDto;
import com.controlfood.interfaces.http.dto.ProductResponse;
import com.controlfood.interfaces.http.mapper.ProductDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController implements ProductControllerApi {

    private final ProductDtoMapper productDtoMapper;
    private final CreateProduct createProduct;
    private final FindAllProducts findAllProducts;
    private final FindProductById findProductById;

    public ResponseEntity<ProductResponse> saveProduct(ProductDto productDto) {
        Product product = createProduct.invoke(productDtoMapper.toEntity(productDto));
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(productDtoMapper.toProducResponse(product));
    }

    @Override
    public ResponseEntity<List<ProductResponse>> findAll() {
        List<Product> products = findAllProducts.invoke();
        List<ProductResponse> productResponses = products.stream().map(productDtoMapper::toProducResponse).toList();
        return ResponseEntity.ok(productResponses);
    }

    @Override
    public ResponseEntity<ProductResponse> findById(Long id) {
        Product product = findProductById.invoke(id);
        return ResponseEntity.ok(productDtoMapper.toProducResponse(product));
    }

}
