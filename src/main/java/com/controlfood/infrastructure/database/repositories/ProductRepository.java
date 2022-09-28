package com.controlfood.infrastructure.database.repositories;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.protocols.FindAllProductRepository;
import com.controlfood.domain.protocols.FindByProductByIdRepository;
import com.controlfood.domain.protocols.SaveProductRepository;
import com.controlfood.domain.protocols.UpdateProductRepository;
import com.controlfood.infrastructure.database.mapper.ProductMapper;
import com.controlfood.infrastructure.database.model.ProductModel;
import com.controlfood.infrastructure.database.repositories.jpa.JpaProductRepository;
import com.controlfood.infrastructure.database.repositories.jpa.specifications.JpaProductSpecification;
import com.controlfood.infrastructure.database.repositories.jpa.specifications.SearchCriteria;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.controlfood.infrastructure.database.repositories.jpa.specifications.SearchOperation.EQUAL;

@Component
@RequiredArgsConstructor
@Slf4j
public class ProductRepository implements SaveProductRepository,
        FindAllProductRepository,
        FindByProductByIdRepository,
        UpdateProductRepository {

    private static final String STATUS = "status";

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
        SearchCriteria searchCriteria = new SearchCriteria(STATUS, 1, EQUAL);
        List<ProductModel> productModels = jpaProductRepository.findAll(getSpecification(searchCriteria));
        log.info("Searched for all products");
        return productModels.stream().map(productMapper::toEntity).collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        Optional<ProductModel> foundProduct = jpaProductRepository.findById(id);
        if (foundProduct.isEmpty()) {
            return null;
        }
        return productMapper.toEntity(foundProduct.get());
    }

    @Override
    public Product update(Product product) {
        return this.save(product);
    }

    private JpaProductSpecification getSpecification(SearchCriteria... searchCriteria) {
        return new JpaProductSpecification(List.of(searchCriteria));
    }


}
