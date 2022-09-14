package com.controlfood.infrastructure.database.repositories;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.protocols.FindAllProductRepository;
import com.controlfood.domain.protocols.SaveProductRepository;
import com.controlfood.infrastructure.database.mapper.ProductMapper;
import com.controlfood.infrastructure.database.model.ProductModel;
import com.controlfood.infrastructure.database.repositories.jpa.JpaProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductRepository implements SaveProductRepository, FindAllProductRepository {

    private final ProductMapper productMapper;
    private final JpaProductRepository jpaProductRepository;

    @Override
    public Product save(Product product) {
        ProductModel productModel;
        try {
            productModel = jpaProductRepository.save(productMapper.toModel(product));
            log.info("Saved a new product with id {}", productModel.getId());
            return productMapper.toEntity(productModel);
        } catch (DataIntegrityViolationException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Product> findAll() {
        List<ProductModel> productModels = jpaProductRepository.findAll();
        log.info("Searched for all products");
        return productModels.stream().map(productMapper::toEntity).collect(Collectors.toList());
    }
}
