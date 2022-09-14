package com.controlfood.infrastructure.database.repositories;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.protocols.SaveProductRepository;
import com.controlfood.infrastructure.database.mapper.ProductMapper;
import com.controlfood.infrastructure.database.model.ProductModel;
import com.controlfood.infrastructure.database.repositories.jpa.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductRepository implements SaveProductRepository {

    private final ProductMapper productMapper;
    private final JpaProductRepository jpaProductRepository;

    @Override
    public Product save(Product product) {
        ProductModel productModel;
        try {
            productModel = jpaProductRepository.save(productMapper.toModel(product));
            return productMapper.toEntity(productModel);
        } catch (DataIntegrityViolationException exception) {
            exception.printStackTrace();
            return null;
        }
    }

}
