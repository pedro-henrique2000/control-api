package com.controlfood.domain.protocols;

import com.controlfood.domain.entities.Product;

public interface FindByProductByIdRepository {
    Product findById(Long id);
}
