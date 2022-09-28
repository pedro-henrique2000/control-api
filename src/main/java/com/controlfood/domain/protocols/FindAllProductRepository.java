package com.controlfood.domain.protocols;

import com.controlfood.domain.entities.Product;
import com.controlfood.domain.entities.search.ProductSearch;

import java.util.List;

public interface FindAllProductRepository {
    List<Product> findAll(ProductSearch productSearch);
}
