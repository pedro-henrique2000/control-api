package com.controlfood.interfaces.http.controller.api;

import com.controlfood.interfaces.http.dto.ProductDto;
import com.controlfood.interfaces.http.dto.ProductPartialDTO;
import com.controlfood.interfaces.http.dto.ProductResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("v1/api/products")
public interface ProductControllerApi {

    @PostMapping()
    ResponseEntity<ProductResponse> saveProduct(@Valid @RequestBody ProductDto productDto);

    @GetMapping()
    ResponseEntity<List<ProductResponse>> findAll();

    @GetMapping("/{id}")
    ResponseEntity<ProductResponse> findById(@PathVariable Long id);

    @PutMapping("/{id}")
    ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductDto productDto);

    @PatchMapping("/{id}")
    ResponseEntity<ProductResponse> updatePartial(@PathVariable Long id, @RequestBody ProductPartialDTO productDto);

}
