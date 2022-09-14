package com.controlfood.interfaces.http.controller;

import com.controlfood.application.CreateProduct;
import com.controlfood.domain.entities.Product;
import com.controlfood.interfaces.http.controller.api.ProductControllerApi;
import com.controlfood.interfaces.http.dto.ProductDto;
import com.controlfood.interfaces.http.dto.ProductResponse;
import com.controlfood.interfaces.http.mapper.ProductDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ProductController implements ProductControllerApi {

    private final ProductDtoMapper productDtoMapper;
    private final CreateProduct createProduct;

    public ResponseEntity<ProductResponse> saveProduct(ProductDto productDto) {
        Product product = createProduct.invoke(productDtoMapper.toEntity(productDto));
        return ResponseEntity.ok(productDtoMapper.toProducResponse(product));
    }

}
