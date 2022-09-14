package com.controlfood.application.product;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.errors.BusinessException;
import com.controlfood.domain.protocols.SaveProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProduct {

    private final SaveProductRepository saveProductRepository;

    public Product invoke(Product product) {
        Product savedProduct = saveProductRepository.save(product);
        if (savedProduct == null) {
            throw new BusinessException("Product with name " + product.getName() + " already exists!");
        } else {
            return savedProduct;
        }
    }
}
