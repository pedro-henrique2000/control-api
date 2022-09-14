package com.controlfood.infrastructure.database.repositories.jpa;

import com.controlfood.infrastructure.database.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JpaProductRepository extends JpaRepository<ProductModel, Long>,
        JpaSpecificationExecutor<ProductModel> {
}
