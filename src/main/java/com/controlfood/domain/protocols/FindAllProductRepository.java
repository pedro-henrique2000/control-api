package com.controlfood.domain.protocols;

import com.controlfood.domain.entities.Product;

import java.util.List;

public interface FindAllProductRepository {
    List<Product> findAll();
}
