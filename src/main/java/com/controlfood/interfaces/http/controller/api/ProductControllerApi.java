package com.controlfood.interfaces.http.controller.api;

import com.controlfood.interfaces.http.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("v1/api/products")
public interface ProductControllerApi {

    @PostMapping()
    ResponseEntity<ProductDto> saveProduct(@Valid @RequestBody ProductDto productDto);

}
