package com.controlfood.infrastructure.database.repositories.jpa;

import com.controlfood.infrastructure.database.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaProductRepository extends JpaRepository<ProductModel, Long> {
}
