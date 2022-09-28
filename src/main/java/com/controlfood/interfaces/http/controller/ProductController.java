package com.controlfood.interfaces.http.controller;

import com.controlfood.application.product.*;
import com.controlfood.domain.entities.Product;
import com.controlfood.interfaces.http.controller.api.ProductControllerApi;
import com.controlfood.interfaces.http.dto.ProductDto;
import com.controlfood.interfaces.http.dto.ProductPartialDTO;
import com.controlfood.interfaces.http.dto.ProductResponse;
import com.controlfood.interfaces.http.mapper.ProductDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ProductController implements ProductControllerApi {

    private final ProductDtoMapper productDtoMapper;
    private final CreateProduct createProduct;
    private final FindAllProducts findAllProducts;
    private final FindProductById findProductById;
    private final UpdateProduct updateProduct;
    private final UpdatePartialProduct updatePartialProduct;

    @Override
    public ResponseEntity<Void> saveProduct(ProductDto productDto) {
        Product product = createProduct.invoke(productDtoMapper.toEntity(productDto));

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.getId())
                .toUri();

        return ResponseEntity.created(location).build();
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

    @Override
    public ResponseEntity<ProductResponse> update(Long id, ProductDto productDto) {
        productDto.setId(id);
        Product product = productDtoMapper.toEntity(productDto);
        updateProduct.invoke(product);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Override
    public ResponseEntity<ProductResponse> updatePartial(Long id, ProductPartialDTO productDto) {
        updatePartialProduct.invoke(id, productDto);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
