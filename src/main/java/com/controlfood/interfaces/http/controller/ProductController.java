package com.controlfood.interfaces.http.controller;

import com.controlfood.interfaces.http.controller.api.ProductControllerApi;
import com.controlfood.interfaces.http.dto.ProductDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class ProductController implements ProductControllerApi {

    public ResponseEntity<ProductDto> saveProduct(ProductDto productDto) {
        //TODO: save
        log.info("Received {}", productDto);
        return ResponseEntity.ok(productDto);
    }

}
